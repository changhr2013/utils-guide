package com.changhr.utils.filters;

import com.changhr.utils.filters.base.Request;
import com.changhr.utils.filters.base.Response;
import com.changhr.utils.filters.filter.HtmlFilter;
import com.changhr.utils.filters.filter.SensitiveFilter;

/**
 * @author changhr
 * @create 2019-11-22 10:24
 */
public class FilterChainTest {

    /** main 方法模拟 Tomcat，假设现在浏览器有一个请求过来 */
    public static void main(String[] args) {
        // Tomcat 准备了 Request，Response
        Request request = new Request();
        Response response = new Response();

        // 过滤器链
        FilterChain filterChain = new FilterChain();
        // 注册过滤器，可以看看 FilterChain 是如何实现链式调用的
        filterChain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
        // 开始执行过滤器
        filterChain.doFilter(request, response);
    }
}
