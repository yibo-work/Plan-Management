package com.utils;

import com.pojo.Prop;
import com.pojo.User;

import java.util.*;

/**
 * @author Clrvn
 * @description 数据工具类
 * @date 2020/4/18 0018 17:01
 */
public class DataUtil {

    /**
     * 定义用户列表
     */
    public static List<User> userList = new ArrayList<>();
    /**
     * 定义属性列表
     */

    public static Set<Prop> propList = new LinkedHashSet<>();
    /**
     * 自定义数据列表
     */
    public static List<Map<Prop, Object>> dataList = new ArrayList<>();

    static {
        User user = new User();
        user.setName("admin");
        user.setPassword("123");
        userList.add(user);
    }

    static {
        Prop prop = new Prop();
        prop.setOrder(1);
        prop.setName("测试字段1");
        prop.setType(1);
        prop.setRequired(false);
        prop.setScopeStart(0);
        prop.setScopeEnd(1000);
        prop.setLengthStart(0);
        prop.setLengthEnd(0);
        prop.setUnit("测试单位");
        prop.setParam("测试参数");
        Prop prop2 = new Prop();
        prop2.setOrder(2);
        prop2.setName("测试字段2");

        propList.add(prop);
        propList.add(prop2);
    }

    static {

        Map<Prop, Object> data = new HashMap<>();
        for (Prop prop : propList) {
            data.put(prop, "测试数据");
        }

        dataList.add(data);
    }

    private DataUtil() {
    }

    public static void main(String[] args) {
        /*System.err.println(DataUtil.propList.removeIf(prop -> "测试字段".equals(prop.getName())));
        System.out.println(DataUtil.propList.size());*/

       /* DataUtil.propList.stream()
                .sorted(Comparator.comparingInt(Prop::getOrder))
                .forEach(System.out::println);*/
    }

}
