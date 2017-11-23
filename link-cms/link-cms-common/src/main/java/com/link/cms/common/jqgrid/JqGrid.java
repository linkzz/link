package com.link.cms.common.jqgrid;

/**
 * @ClassName: JqGrid
 * @Description: JqGrid 公共属性
 * @author: linkzz
 * @data: 2017-05-06 21:58
*/
public class JqGrid {
    /**
     * 表示请求页码的参数名称
     */
    private int page;
    /**
     * 表示请求行数的参数名称
     */
    private int rows;
    /**
     * 表示采用的排序方式的参数名称 升序	or 倒序
     */
    private String sord;
    /**
     * 表示请求行数的参数名称
     */
    private String order;
    /**
     * 表示请求行数的参数名称
     */
    private String ids;
    /**
     * 当前操作  删除/编辑or新增
     */
    private String oper;			//
    /**
     * 组合搜索过滤条件
     */
    private String filters;
    /**
     * 是否为高级查询
     */
    private String multipleSearch;
    /**
     * 表示是否是搜索请求的参数名称
     */
    private String _search;
    /**
     * 查询字段
     */
    private String searchField;
    /**
     * 搜索
     */
    private String searchOper;
    /**
     * 搜索字符串
     */
    private String searchString;
    /**
     * 表示用于排序的列名的参数名称
     */
    private String sidx;
    /**
     * 表示已经发送请求的次数的参数名称
     */
    private String nd;
    /**
     * 当在edit模式中提交数据时，操作的名称
     */
    private String edit;
    /**
     * 当在add模式中提交数据时，操作的名称
     */
    private String add;
    /**
     * 当在delete模式中提交数据时，操作的名称
     */
    private String del;

    /**
     * 返回结果代码
     */
    public String resultCode;
    /**
     * 返回结果信息
     */
    public String resultMsg;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getMultipleSearch() {
        return multipleSearch;
    }

    public void setMultipleSearch(String multipleSearch) {
        this.multipleSearch = multipleSearch;
    }

    public String get_search() {
        return _search;
    }

    public void set_search(String _search) {
        this._search = _search;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchOper() {
        return searchOper;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
