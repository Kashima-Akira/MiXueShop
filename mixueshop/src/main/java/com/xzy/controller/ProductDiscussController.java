package com.xzy.controller;


import com.xzy.pojo.DiscussImage;
import com.xzy.pojo.Product;
import com.xzy.pojo.ProductDiscuss;
import com.xzy.pojo.User;
import com.xzy.service.ProductDiscussService;
import com.xzy.utils.Base64ToMul;
import com.xzy.utils.DiscussVo;
import com.xzy.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ProductDiscussController
{
    @Autowired
    private ProductDiscussService productDiscussService;



    @Value("${FASTDFS_IMAGE_URL}")
    private String FASTDFS_IMAGE_URL;

    //插入图片或者评论
    @RequestMapping(value = "/insertDiscussController")
    @ResponseBody
    public Object insertDiscussController(@RequestBody(required=false) DiscussVo vo , HttpSession session){


        List<Map> maps=vo.getImage();
        List<String> image=new ArrayList<>();
          if(maps!=null) {
              for (Map src : maps) {
                  image.add((String) src.get("src"));
              }
          }

        User user=(User) session.getAttribute("user");
        if (user==null)
        {
            return "请您登陆";
        }
        ProductDiscuss productDiscuss=new ProductDiscuss();
        productDiscuss.setDescript(vo.getDescript());
        productDiscuss.setOrdersId(vo.getOrdersId());
        productDiscuss.setProductId(vo.getProductId());
        productDiscuss.setState(vo.getState());

        //上传评论到数据库

        if (productDiscuss!=null)
        {
            productDiscuss.setGood(1);
            productDiscuss.setUserId(user.getId());
            productDiscuss.setCreated(new Date());

            productDiscussService.insertDiscuss(productDiscuss);
//            //更新评分
           productDiscussService.UpdateProductLevel(productDiscuss.getProductId());
            //更新订单状态
            Map map=new HashMap();
            map.put("productId",productDiscuss.getProductId());
            map.put("ordersId",productDiscuss.getOrdersId());

            productDiscussService.updateItemState(map);

        }
        //上传图片到数据库
        if (image!=null)
        {
            for (String i:image)
            {
                DiscussImage discussImage=new DiscussImage();
                discussImage.setPath(i);
                discussImage.setId(UUID.randomUUID().toString());
                discussImage.setProductDiscussId(productDiscuss.getId());
                productDiscussService.insertDiscussImages(discussImage);
            }
        }

        return "上传成功";
    }
    @RequestMapping(value = "/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestBody String img)
    {

        if (img==null)
        {
            return "请添加图片";
        }else {

                Base64ToMul base64ToMul = new Base64ToMul();
                MultipartFile multipartFile = base64ToMul.base64ToMultipart(img);


                try {
                    FastDFSClient fastDFSClient = new FastDFSClient("classpath:client.conf");


                    String originalFilename = multipartFile.getOriginalFilename();
                    String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

                    String name = fastDFSClient.uploadFile(multipartFile.getBytes(), extName);
                    String imagepath ="http://47.95.249.186:8080/" + name;
                    return imagepath;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        return "上传成功";
    }

    //删除评论
    @RequestMapping("/deleteProductDiscussController")
    @ResponseBody
    public String deleteProductDiscussController(@RequestParam("ordersid")String ordersid)
    {
        //productDiscussService.deleteDiscussByProductId("10");
        productDiscussService.deleteDiscussByProductId(ordersid);
        return "ok";
    }
    //分页查询评论
    @RequestMapping("/selectProductDiscussController")
    @ResponseBody
    public List<ProductDiscuss> selectProductDiscussController(Integer productid,Integer pageNum)
    {
        Map map=new HashMap();

        map.put("productid",productid);
        map.put("pageNum",(pageNum-1)*10);

        return productDiscussService.selectALL(map);
    }


    //查询某用户对某商品的个人评论
    @RequestMapping("/selectByOrdersId")
    @ResponseBody
    public List<ProductDiscuss> selectByOrdersId(@RequestParam("ordersid")String ordersid)
    {
        //   List<ProductDiscuss> list= productDiscussService.selectDisscussByOrders(ordersid);
        List<ProductDiscuss> list= productDiscussService.selectDisscussByOrders("400");

        return list;
    }

    //查询评论条数
    @RequestMapping("/countController")
    @ResponseBody
    public Integer countController(@RequestParam("productid") Integer productid)
    {
        Integer count= productDiscussService.countDiscussService(productid);
        return count;
    }

    //更新赞数量（默认加一）
    @RequestMapping(value = "/updateDiscussGoood" )
    @ResponseBody
    public void updateDiscussGood(String discussId)
    {
        productDiscussService.upadeaeGoods(discussId);
    }


    //待评价商品的简要信息
    @RequestMapping("/selectRemain")
    @ResponseBody
    public List<remainResponse> selectRemain(String ordersid)
    {

        //ordersid="1";
        List<remainResponse> list =new ArrayList<>();
        //得到商品id
        List<Integer> ids=productDiscussService.selectProductIdByordersid(ordersid);

       for (Integer id: ids)
        {
            Map resultMap=new HashMap();
            resultMap.put("ordersid",ordersid);
            resultMap.put("id",id);

            List<Map> map=productDiscussService.selectnameAndpath(resultMap);

            Iterator iterator=map.iterator();
            while (iterator.hasNext())
            {
                Map map2=(Map) iterator.next();

                Set set = map2.keySet();
                int i=0;
                remainResponse remain=new remainResponse();

                for(Object o:set){

                    if(o.toString().equals("id"))
                    {
                        remain.setId(map2.get(o));
                        i++;
                    }
                    if(o.toString().equals("name"))
                    {
                        remain.setName(map2.get(o));
                        i++;
                    }
                    if(o.toString().equals("path"))
                    {
                        remain.setImagepath(map2.get(o));
                        i++;
                    }
                    if(o.toString().equals("insertTime"))
                    {
                        remain.setOrderstime(map2.get(o));
                        i++;
                    }
                    if(o.toString().equals("state"))
                    {
                        remain.setState(map2.get(o));
                        i++;
                    }
                    if(i==4)
                    {
                        list.add(remain);
                        i=0;
                    }
                }

           }
        }


        return list;
    }







}
