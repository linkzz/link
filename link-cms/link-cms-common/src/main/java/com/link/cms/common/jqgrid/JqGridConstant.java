package com.link.cms.common.jqgrid;

/**
 * @ClassName: JqGridConstant
 * @Description: jqGrid常量
 * @author: linkzz
 * @data: 2017-05-08 16:08
*/
public class JqGridConstant {
    //jqGrid 页面参数常量
    /**
     * 编辑
     */
    public static String EDIT = "edit";
    /**
     * 添加
     */
    public static String ADD = "add";
    /**
     * 删除
     */
    public static String DEL = "del";

    //组合查询
    /**
     * 组合查询 OR
     */
    public static String GROUPOP_OR = "OR";
    /**
     * 组合查询ADD
     */
    public static String GROUPOP_ADD = "ADD";

    //查询条件
    /**
     * 相等=
     */
    public static String OP_EQUAL = "eq";
    /**
     * 不相等<>
     */
    public static String OP_NOT_EQUAL = "ne";
    /**
     * 小于 		<
     */
    public static String OP_LESS = "lt";
    /**
     * 小于或等于	<=
     */
    public static String OP_LESS_OR_EQUAL = "le";
    /**
     * 大于		>
     */
    public static String OP_GREATER = "gt";
    /**
     * 大于或等于	>=
     */
    public static String OP_GREATER_OR_EQUAL = "ge";
    /**
     * 以什么开始	like %xxx
     */
    public static String OP_BEGINS_WITH = "bw";
    /**
     * 不以什么开始	not like %xxx
     */
    public static String OP_DOES_NOT_BEGIN_WITH = "bn";
    /**
     * in()
     */
    public static String OP_IS_IN = "in";
    /**
     * not in()
     */
    public static String OP_IS_NOT_IN = "ni";
    /**
     * 以什么结束	like xxx%
     */
    public static String OP_ENDS_WITH = "ew";
    /**
     * 不以什么结束	not like xxx%
     */
    public static String OP_DOES_NOT_ENDS_WITH = "en";
    /**
     * 包含		like %xxx%
     */
    public static String OP_CONTAINS = "cn";
    /**
     * 不包含		not like %xxx%
     */
    public static String OP_DOES_NOT_CONTAINS = "nc";

}
