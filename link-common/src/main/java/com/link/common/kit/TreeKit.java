package com.link.common.kit;

import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * tree 表格数据封装
 * @author linkzz
 * @date 2017-06-28
 */
public class TreeKit{
    private List<Record> list = new ArrayList<>();
    /**
     * 排序完成后的list
     */
    private List<Record> jqGridList = new ArrayList<>();
    private String node_id = "id";
    private Record parent;

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public TreeKit(List<Record> list){
        this.list = list;
    }

    //开始排序
    public List<Record> startSorting(){
        List<Record> roots = findRoots();
        for (Record rootNode : roots){
            jqGridList.add(rootNode);
            deepSearchChildNodes(rootNode);
        }
        return jqGridList;
    }

    public void deepSearchChildNodes(Record parent){
        parent.set("isLeaf",false);
        parent.set("expanded",true);
        List<Record> findChildAtNode = findChildAtNode(parent);
        if (findChildAtNode.size() > 0){
            for (Record n : findChildAtNode){
                if (parent.get("level") == null){
                    parent.set("level","0");
                }
                n.set("level",String.valueOf(Integer.parseInt(parent.get("level"))+1));
                n.set("expanded",true);
            }
        }else {
            parent.set("isLeaf",true);
            parent.set("expanded",false);
        }
        while (findChildAtNode.size() > 0){
            jqGridList.add(findChildAtNode.get(0));
            deepSearchChildNodes(findChildAtNode.get(0));
            findChildAtNode.remove(0);
        }
    }

    public List<Record> findRoots(){
        List<Record> roots = new ArrayList<>();
        for (Record n : list){
            if (n.get("parent") == null || "".equals(n.get("parent"))){
                n.set("level","0");
                roots.add(n);
            }
        }
        return roots;
    }

    public List<Record> findChildAtNode(Record currentNode){
        List<Record> childs = new ArrayList<>();
        for (Record n : list){
            if (n == currentNode) {
                continue;
            }
            if (currentNode.get("id").equals(n.get("parent"))){
                childs.add(n);
            }
        }
        return childs;
    }
}
