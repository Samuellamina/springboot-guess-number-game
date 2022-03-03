package samuel.tutorials.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("preHandle method called. handler = {}", handler);
        log.debug("URL = {}", request.getRequestURL());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("postHandle method called. handler = {}", handler);
        log.debug("URL = {}", request.getRequestURL());
        log.debug("model = {}", modelAndView.getModel());
        log.debug("view = {}", modelAndView.getViewName());
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("afterCompletion  method called. handler = {}", handler);
        log.debug("URL = {}", request.getRequestURL());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
