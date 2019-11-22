package com.changhr.utils.filters.filter;

import com.changhr.utils.filters.FilterChain;
import com.changhr.utils.filters.base.Request;
import com.changhr.utils.filters.base.Response;

/**
 * @author changhr
 * @create 2019-11-22 10:32
 */
public interface Filter {

    void doFilter(Request request, Response response, FilterChain chain);
}
