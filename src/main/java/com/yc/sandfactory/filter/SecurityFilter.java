package com.yc.sandfactory.filter;

import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.token.TokenFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/9 下午11:07
 */
@WebFilter(filterName = "adminTokenFilter", value = {"/admin/*"})
public class SecurityFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String URL_PREF = "admin/";

    private static final String PUBLIC_PREF = "admin/public";

    private static final String ANONY_PREF = "admin/anony";

    /**
     * @Fields wac:Spring的上下文
     */
    private WebApplicationContext wac;
    /**
     * @Fields tokenFactory:Token工厂
     */
    @Autowired
    private TokenFactory tokenFactory;

    /**
     * 初始化过滤器,将公共地址添加到列表中
     */
    @Override
    public void init(FilterConfig config) {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    //根据token进行的验证
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        //请求地址
        String uri = request.getRequestURI().substring(request.getContextPath().length() + 1);
        logger.debug(uri);
        //1.验证是否是公共url地址
        if(!uri.startsWith(PUBLIC_PREF)) {//非公共地址
            //2.验证是否有token
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            String token = authHeader.substring(7); // The part after "Bearer "

            //3.是否登录
            SysUser user = null;
            try {
                user = (SysUser) tokenFactory.getOperator().get(token);
                if(user == null){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            request.setAttribute("loginUser", user);
            //4.验证当前请求是否是登陆后不需要验证的地址
            if(!uri.startsWith(ANONY_PREF)) {
                //不是登录后免检的地址
                //5.验证当前用户的请求是否在自身的权限列表中
                uri = uri.substring(URL_PREF.length(), uri.length());
                int index = uri.indexOf('/');
                uri = index != -1 ? uri.substring(0, index) : uri;
                logger.debug(uri);
                //验证用户的权限列表中有没有权限
                //TODO
				/*if(!user.getPermissions().contains(uri)) {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					return;
				}*/
            }
        }
        //公共地址放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
