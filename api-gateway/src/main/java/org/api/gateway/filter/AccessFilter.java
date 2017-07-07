package org.api.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component//需要实例化该过滤器
public class AccessFilter extends ZuulFilter{

	/*
	 * shouldFilter：返回一个boolean类型来判断该过滤器是否要执行
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * filterOrder：通过int值来定义过滤器的执行顺序
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * filterType:返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：   
             pre：可以在请求被路由之前调用
             routing：在路由请求时候被调用
             post：在routing和error过滤器之后被调用
             error：处理请求时发生错误时被调用
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	/*
	 * run：过滤器的具体逻辑。
	 */
	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		String token=request.getParameter("token");
		if(token==null){
			ctx.setSendZuulResponse(false);
//			ctx.getResponse().setCharacterEncoding("utf-8");
			//设置浏览器解码
			ctx.getResponse().setContentType("text/html;charset=utf-8");
			ctx.setResponseBody("非法访问!!");
			ctx.setResponseStatusCode(401);
			return null;
		}
		return null;
	}
}
