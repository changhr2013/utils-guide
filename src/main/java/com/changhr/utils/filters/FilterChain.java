package com.changhr.utils.filters;

import com.changhr.utils.filters.base.Request;
import com.changhr.utils.filters.base.Response;
import com.changhr.utils.filters.filter.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changhr
 * @create 2019-11-22 10:32
 */
public class FilterChain {

    /** 标识当前执行到第几个过滤器 */
    private int index = 0;

    /** 所有已注册的过滤器 */
    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        // 所有过滤器执行完毕，return
        if (index == filters.size()) {
            return;
        }
        // 得到过滤器
        Filter filter = filters.get(index);
        // 自增操作不能和 doFilter() 方法互换
        index++;
        // 执行过滤器
        filter.doFilter(request, response, this);
    }

}
