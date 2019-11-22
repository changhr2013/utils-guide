package com.changhr.utils.filters.filter;

import com.changhr.utils.filters.FilterChain;
import com.changhr.utils.filters.base.Request;
import com.changhr.utils.filters.base.Response;

/**
 * @author changhr
 * @create 2019-11-22 10:42
 */
public class SensitiveFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.doSomething("SensitiveFilter request");
        chain.doFilter(request, response);
        response.doSomething("SensitiveFilter response");
    }
}
