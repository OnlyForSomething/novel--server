package com.getnovel.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import utils.JwtResult;
import utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    /**
     * 进入controller之前进行拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token ="";
        if(!StringUtils.isEmpty(request.getHeader("Authorization"))){
            token =request.getHeader("Authorization");
           // System.out.println(token + "token");
        }else if(StringUtils.isEmpty(request.getHeader("Authorization"))){
            token = request.getParameter("Authorization");
        }
        if (!StringUtils.isEmpty(token)){
            JwtResult jr = JwtUtils.checkToken(token);
           // System.out.println(jr + "lanjie");
            if (jr.getClaims() ==null && jr.getCode()==401){
                response.setStatus(401);
            }
            if(!StringUtils.isEmpty(jr.getClaims())){
                Integer userId = (Integer) jr.getClaims().get("id");
                String username =(String) jr.getClaims().get("username");
                request.setAttribute("user_id",userId);
                request.setAttribute("username",username);
            }
            return  true;
        } else {
            response.setStatus(401);
        }
        return false;
    }
}
