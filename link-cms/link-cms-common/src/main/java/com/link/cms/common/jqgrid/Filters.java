package com.link.cms.common.jqgrid;

import java.util.List;

/**
 * 封装查询组规则
 * @author linkzz
 * @date 2017-05-12
 */
public class Filters {
    private String groupOp;
    private List<Rules> rules;
    private List<Groups> groups;

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public List<Rules> getRules() {
        return rules;
    }

    public void setRules(List<Rules> rules) {
        this.rules = rules;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
