package com.xzy.pojo;

import java.util.Iterator;
import java.util.Map;

public class EasyRegist {
    String name;
    String email;
    String telephone;
    String password;
    String code;
    Boolean flag;
    Map<String,String> err;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Map<String, String> getErr() {
        return err;
    }

    public void setErr(Map<String, String> err) {
        this.err = err;
    }

    public void testIterator() {
        Iterator<Map.Entry<String, String>> it = getErr().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    @Override
    public String toString() {
        return "EasyRegist{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", flag=" + flag +
                ", err=" + err +
                '}';
    }
}
