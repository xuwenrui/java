package com.frank;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
    private static Logger LOGGER=LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        LOGGER.info("%s >>> %s",request.getMethod(),request.getRequestURI().toString());
        Object accessToken=request.getParameter("token");
        if (accessToken != null){
            return null;
        }
        LOGGER.warn("");
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(401);
        try {
            ctx.getResponse().getWriter().write("token is empty");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
