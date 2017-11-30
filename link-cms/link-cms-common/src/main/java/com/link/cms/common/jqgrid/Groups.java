package com.link.cms.common.jqgrid;

import java.util.List;

/**
 * 查询组规则
 * @author linkzz
 * @date 2017-05-12
 */
public class Groups {
    private String groupOp;
    private List<Rules> rules;
    private List<Groups> groupsList;

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

    public List<Groups> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<Groups> groupsList) {
        this.groupsList = groupsList;
    }
}
