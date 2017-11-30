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
     * jqgrid 数表格复用字段
     */
    private static final String ISLEAF = "isLeaf";
    private static final String EXPANDED = "expanded";
    private static final String LEVEL = "level";
    private static final String PARENT = "parent";
    /**
     * 排序完成后的list
     */
    private List<Record> jqGridList = new ArrayList<>();

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
        parent.set(ISLEAF,false);
        parent.set(EXPANDED,true);
        List<Record> findChildAtNode = findChildAtNode(parent);
        if (findChildAtNode.isEmpty()){
            for (Record n : findChildAtNode){
                if (parent.get(LEVEL) == null){
                    parent.set(LEVEL,"0");
                }
                n.set(LEVEL,String.valueOf(Integer.parseInt(parent.get(LEVEL))+1));
                n.set(EXPANDED,true);
            }
        }else {
            parent.set(ISLEAF,true);
            parent.set(EXPANDED,false);
        }
        while (findChildAtNode.isEmpty()){
            jqGridList.add(findChildAtNode.get(0));
            deepSearchChildNodes(findChildAtNode.get(0));
            findChildAtNode.remove(0);
        }
    }

    public List<Record> findRoots(){
        List<Record> roots = new ArrayList<>();
        for (Record n : list){
            if (n.get(PARENT) == null || "".equals(n.get(PARENT))){
                n.set(LEVEL,"0");
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
            if (currentNode.get("id").equals(n.get(PARENT))){
                childs.add(n);
            }
        }
        return childs;
    }
}
