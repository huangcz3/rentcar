package com.bs.util;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * AuthImage Description:(验证码)
 * @author User
 */
public class AuthImage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        System.out.println("AuthImage.service()");
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session  
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("randStr");
        //设置新的验证码
        session.setAttribute("randStr", verifyCode.toLowerCase());
        //生成图片  
        int w = 107, h = 38;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

    }
} 