package com.miidi.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/11/30.
 */
@Component
public class Pre0Filter extends ZuulFilter{

    /***
     * 顺序: pre ->routing -> post ,以上3个顺序出现异常时都可以触发error类型的filter
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /***
     * 同filterType类型中，order值越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否应该执行该过滤器，如果是false，则不执行该filter
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String prefilter0 = request.getParameter("prefilter0");
        System.out.println("执行pre0Filter .....prefilter0=" + prefilter0 	);

        //如果用户名和密码都正确，则继续执行下一个filter
        if("true".equals(prefilter0) ){
            ctx.setSendZuulResponse(true);//会进行路由，也就是会调用api服务提供者
            ctx.setResponseStatusCode(200);
            ctx.set("isOK",true);//可以把一些值放到ctx中，便于后面的filter获取使用
        }else{
            ctx.setSendZuulResponse(false);//不需要进行路由，也就是不会调用api服务提供者
            ctx.setResponseStatusCode(401);
            ctx.set("isOK",false);//可以把一些值放到ctx中，便于后面的filter获取使用
            //返回内容给客户端
            ctx.setResponseBody("{\"result\":\"pre01Filter auth not correct!\"}");// 返回错误内容
        }
        return null;
    }

}
