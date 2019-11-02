package com.xbb.utils;

import com.xbb.entity.Admin;
import com.xbb.entity.Order;
import com.xbb.service.*;
import com.xbb.service.Impl.*;
import com.xbb.service.base.BaseCrudService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: ServiceUtils
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\26 00260:47
 */
public class ServiceUtils {

    private static Map<String, BaseCrudService> serviceMap = new HashMap<>();

    static {
        serviceMap.put(BookService.class.getSimpleName(), new BookServiceImpl());
        serviceMap.put(AdminService.class.getSimpleName(), new AdminServiceImpl());
        serviceMap.put(CartItemService.class.getSimpleName(), new CartItemServiceImpl());
        serviceMap.put(CategoryService.class.getSimpleName(), new CategoryServiceImpl());
        serviceMap.put(ClassifyService.class.getSimpleName(), new ClassifyServiceImpl());
        serviceMap.put(OrderItemService.class.getSimpleName(), new OrderItemServiceImpl());
        serviceMap.put(OrderService.class.getSimpleName(), new OrderServiceImpl());
        serviceMap.put(UserService.class.getSimpleName(), new UserServiceImpl());
    }

    public static <T> T getService(Class clz){
        return (T) serviceMap.get(clz.getSimpleName());
    }

}
