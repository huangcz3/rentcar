package com.bs.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author User
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final String URL = "/login";

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
        if (URL.equals(req.getRequestURI())) {
            return true;
        } else {
            Object obj = req.getSession().getAttribute("user");
            if (obj != null) {
                return true;
            } else {
                resp.sendRedirect("login");
                return false;
            }
        }

    }

}
