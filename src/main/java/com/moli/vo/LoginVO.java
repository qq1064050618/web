package com.moli.vo;
import lombok.Data;

@Data
public class LoginVO {
    private int status;
    private String message;
    public static LoginVO ok(){
        LoginVO loginVO=new LoginVO();
        loginVO.setStatus(10);
        loginVO.setMessage("存在");
        return loginVO;
    }
    public static LoginVO success(){
        LoginVO loginVO=new LoginVO();
        loginVO.setStatus(0);
        loginVO.setMessage("登录成功！");
        return loginVO;
    }
    public static LoginVO error(int status,String message){
        LoginVO loginVO=new LoginVO();
        loginVO.setStatus(status);
        loginVO.setMessage(message);
        return  loginVO;
    }
}
