package com.atm.interceptor;

import com.atm.domain.Card;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/19/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {

        Card card = (Card) request.getSession().getAttribute("Card");
        if (card == null) {
            response.sendRedirect("/ATM/");
            return false;
        } else {
            return true;
        }
    }
}
