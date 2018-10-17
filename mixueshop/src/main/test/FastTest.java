import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * Created by css on 2018/8/1.
 */
public class FastTest {
    @Test
    public void testUpload()throws Exception{

        ClientGlobal.init("C:\\Users\\Administrator\\Desktop\\git\\sweety\\mixueshop\\src\\main\\resources\\client.conf");
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageServer storageServer=null;
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);
        String[] jpgs = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\281532397q7x.jpg", "jpg", null);
        System.out.print("http://47.95.249.186:8080/");
        for (String str : jpgs){
            System.out.print(str+"/");
        }
    }
}
