package com.jas.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 琚安生
 * @since 设计wiki | 需求wiki
 */
//自定义Filter
@Configuration
public class MyFilter extends ZuulFilter{

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    //定义filter的类型，有pre、route、post、error四种
    @Override
    public String filterType() {
        return "pre";
    }

    //定义filter的顺序，数字越小表示顺序越高，越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //表示是否需要执行该filter，true表示执行，false表示不执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //filter需要执行的具体操作
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String msg = request.getParameter("msg");
        LOGGER.info("requestMethod:{},requestParams:{}", request.getMethod(), request.getParameterMap());
        if ("jas".equals(msg)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.set("isSuccess", false);
        }else {
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            context.set("isSuccess", true);
        }
        return null;
    }
}
