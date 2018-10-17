package com.xzy.pojo;

import java.util.Iterator;
import java.util.Map;

public class EasyLogin {

    String name;
    String password;
    String email;
    String code;
    Boolean flag;
    Map<String,String> err;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "EasyLogin{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", flag=" + flag +
                ", err=" + err +
                '}';
    }
}
