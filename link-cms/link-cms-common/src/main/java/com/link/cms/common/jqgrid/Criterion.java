package com.link.cms.common.jqgrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 组装查询条件
 *
 * @author linkzz
 *
 * @time 2015-05-25
 *
 */
public class Criterion {

	/**
	 * 定义枚举类型 条件类型
	 */
	public static enum CriterionType {
		//相等
		EQUAL,
		//相似
		LIKE,
		//比较
		COMPARE,
		//不相似
		NOT_LIKE
	}

	/**
	 * 定义枚举类型 比较类型
	 */
	public static enum CompareType {
		GT, GTE, LT, LTE, EQ, NE
	}

	/**
	 * 条件类型
	 */
	private CriterionType criterionType;
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 字段名
	 */
	private String field;
	/**
	 * 对应值
	 */
	private Object value;

	public CriterionType getCriterionType() {
		return criterionType;
	}

	public void setCriterionType(CriterionType criterionType) {
		this.criterionType = criterionType;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static Criterion getCompareCriterion(CompareType compareType, String field, Object value, String tableName) {
		CompareCriterion compareCriterion = new CompareCriterion();
		compareCriterion.setCriterionType(CriterionType.COMPARE);
		compareCriterion.setCompareType(compareType);
		compareCriterion.setField(field);
		compareCriterion.setValue(value);
		compareCriterion.setTableName(tableName);
		return compareCriterion;
	}

	public static Criterion getLikeCriterion(String field, Object value, String tableName) {
		LikeCriterion likeCriterion = new LikeCriterion();
		likeCriterion.setCriterionType(CriterionType.LIKE);
		likeCriterion.setField(field);
		likeCriterion.setValue(value);
		likeCriterion.setTableName(tableName);
		return likeCriterion;
	}

	public static Criterion getNotLikeCriterion(String field, Object value, String tableName) {
		NotLikeCriterion notLikeCriterion = new NotLikeCriterion();
		notLikeCriterion.setCriterionType(CriterionType.NOT_LIKE);
		notLikeCriterion.setField(field);
		notLikeCriterion.setValue(value);
		notLikeCriterion.setTableName(tableName);
		return notLikeCriterion;
	}

	public static Criterion getEqualCriterion(String field, Object value, String tableName) {
		EqualCriterion equalCriterion = new EqualCriterion();
		equalCriterion.setCriterionType(CriterionType.EQUAL);
		equalCriterion.setField(field);
		equalCriterion.setValue(value);
		equalCriterion.setTableName(tableName);
		return equalCriterion;
	}

	public static class LikeCriterion extends Criterion {
	}

	public static class NotLikeCriterion extends Criterion {
	}

	public static class EqualCriterion extends Criterion {
	}

	public static class CompareCriterion extends Criterion {
		private CompareType compareType;

		public CompareType getCompareType() {
			return compareType;
		}

		public void setCompareType(CompareType compareType) {
			this.compareType = compareType;
		}
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldPrefix() {
		return (tableName == null || tableName.length() == 0) ? "" : tableName + ".";
	}

	/**
	 * 组装简单查询条件
	 * @author linkzz
	 * @param searchField
	 * @param searchString
	 * @param searchOper
	 * @return Criterion
	 */
	public Criterion generateSearchCriterion(String searchField, String searchString, String searchOper) {
		Criterion criterion = null;
		// 如果searchField、searchString、searchOper均不为null，且searchString不为空串时，则创建Criterion
		if (searchField != null && searchString != null && searchString.length() > 0 && searchOper != null) {
			// 相等
			if (JqGridConstant.OP_EQUAL.equals(searchOper)) {
				criterion = Criterion.getEqualCriterion(searchField, searchString, null);
				// 不相等
			} else if (JqGridConstant.OP_NOT_EQUAL.equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.NE, searchField, searchString, null);
				// 小于
			} else if (JqGridConstant.OP_LESS.equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.LT, searchField, searchString, null);
				// 小于等于
			} else if (JqGridConstant.OP_LESS_OR_EQUAL.equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.LTE, searchField, searchString, null);
				// 大于
			} else if (JqGridConstant.OP_GREATER.equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.GT, searchField, searchString, null);
				// 大于等于
			} else if (JqGridConstant.OP_GREATER_OR_EQUAL.equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.GTE, searchField, searchString, null);
				// 以什么开始
			} else if (JqGridConstant.OP_BEGINS_WITH.equals(searchOper)) {
				criterion = Criterion.getLikeCriterion(searchField, searchString + "%", null);
				// 不以什么开始
			} else if (JqGridConstant.OP_DOES_NOT_BEGIN_WITH.equals(searchOper)) {
				criterion = Criterion.getNotLikeCriterion(searchField, searchString + "%", null);
				// 以什么结束
			} else if (JqGridConstant.OP_ENDS_WITH.equals(searchOper)) {
				criterion = Criterion.getLikeCriterion(searchField, "%" + searchString, null);
				// 不以什么结束
			} else if (JqGridConstant.OP_DOES_NOT_ENDS_WITH.equals(searchOper)) {
				criterion = Criterion.getNotLikeCriterion(searchField, "%" + searchString, null);
				// 包含
			} else if (JqGridConstant.OP_CONTAINS.equals(searchOper)) {
				criterion = Criterion.getLikeCriterion(searchField, "%" + searchString + "%", null);
				// 不包含
			} else if (JqGridConstant.OP_DOES_NOT_CONTAINS.equals(searchOper)) {
				criterion = Criterion.getNotLikeCriterion(searchField, "%" + searchString + "%", null);
			}else if("true".equals(searchOper)){
				criterion = Criterion.getLikeCriterion(searchField, "%" + searchString + "%", null);
			}

		}
		return criterion;
	}

	/**
	 * 组装高级复合查询条件
	 * @author linkzz
	 * @param filters
	 * @return List<Criterion>
	 */
	public List<Criterion> generateSearchCriteriaFromFilters(Filters filters) {
		List<Criterion> criteria = new ArrayList<Criterion>();

		for (Rules rule : filters.getRules()) {
			String field = rule.getField();
			String op = rule.getOp();
			String data = rule.getData();

			Criterion criterion = this.generateSearchCriterion(field, data, op);

			if (criterion != null) {
				criteria.add(criterion);
			}
		}

		return criteria;
	}

	/**
	 * 组装查询条件语句参数
	 * @author linkzz
	 * @param oper
	 * @param field
	 * @param searchString
	 * @param params
	 * @return
	 */
	public Map<String, Object> getParams(String oper, String field, String searchString, Map<String, Object> params) {
		if (JqGridConstant.OP_CONTAINS.equals(oper) || JqGridConstant.OP_DOES_NOT_CONTAINS.equals(oper)) {
			params.put(field, "%%" + searchString + "%%");
		} else if (JqGridConstant.OP_BEGINS_WITH.equals(oper) || JqGridConstant.OP_DOES_NOT_BEGIN_WITH.equals(oper)) {
			params.put(field, searchString + "%%");
		} else if ("ew".equals(oper) || "en".equals(oper)) {
			params.put(field, "%%" + searchString);
		} else {
			params.put(field, searchString);
		}
		return params;
	}

	/**
	 * 组装查询条件语句参数
	 * @author linkzz
	 * @param oper
	 * @param field
	 * @param searchString
	 * @return
	 */
	public List getParams(String oper, String field, String searchString,List params) {
		if (JqGridConstant.OP_CONTAINS.equals(oper) || JqGridConstant.OP_DOES_NOT_CONTAINS.equals(oper)) {
			params.add("%" + searchString + "%");
		} else if (JqGridConstant.OP_BEGINS_WITH.equals(oper) || JqGridConstant.OP_DOES_NOT_BEGIN_WITH.equals(oper)) {
			params.add(searchString + "%");
		} else if ("ew".equals(oper) || "en".equals(oper)) {
			params.add("%" + searchString);
		} else {
			params.add(searchString);
		}
		return params;
	}

	/**
	 * 将Criteria转换为SQL条件语句
	 * @author linkzz
	 * @param criteria
	 * @return String
	 */
	public static String convertToSql(List<Criterion> criteria,String groupOp,String criteriaString) {
		StringBuilder sb = new StringBuilder();
		for (Criterion criterion : criteria) {
			String prefix = criterion.getFieldPrefix();
			switch (criterion.getCriterionType()) {
			case EQUAL:
				sb.append(prefix + criterion.getField() + "=? " + groupOp + " ");
				break;
			case LIKE:
				sb.append(prefix + criterion.getField() + " like ? " + groupOp + " ");
				break;

			case NOT_LIKE:
				sb.append(prefix + criterion.getField() + " not like ? " + groupOp + " ");
				break;
			case COMPARE:
				CompareType compareType = ((CompareCriterion) criterion).getCompareType();
				switch (compareType) {
				case EQ:
					sb.append(prefix + criterion.getField() + "=? " + groupOp + " ");
					break;
				case NE:
					sb.append(prefix + criterion.getField() + "<>? " + groupOp + " ");
					break;
				case GT:
					sb.append(prefix + criterion.getField() + ">? " + groupOp + " ");
					break;
				case GTE:
					sb.append(prefix + criterion.getField() + ">=? " + groupOp + " ");
					break;
				case LT:
					sb.append(prefix + criterion.getField() + "<? " + groupOp + " ");
					break;
				case LTE:
					sb.append(prefix + criterion.getField() + "<=? " + groupOp + " ");
					break;
				}
				break;
			}
		}
		int i = -1;
		if ((i = sb.lastIndexOf(" " + groupOp + " ")) != -1) {
			criteriaString = sb.substring(0, i);
		}
		return criteriaString;
	}

	/**
	 * 将Criteria转换为HQL条件语句
	 * @param criteria
	 * @param groupOp
	 * @return String
	 */
	public static String convertToHql(List<Criterion> criteria, String groupOp) {
		String criteriaString = "";
		StringBuilder sb = new StringBuilder();
		for (Criterion criterion : criteria) {
			String prefix = criterion.getFieldPrefix();
			switch (criterion.getCriterionType()) {
			case EQUAL:
				sb.append(prefix + criterion.getField() + " = :" + criterion.getField() + " " + groupOp + " ");
				break;
			case LIKE:
				sb.append(prefix + criterion.getField() + " like :" + criterion.getField() + " " + groupOp + " ");
				break;

			case NOT_LIKE:
				sb.append(prefix + criterion.getField() + " not like :" + criterion.getField() + " " + groupOp + " ");
				break;
			case COMPARE:
				CompareType compareType = ((CompareCriterion) criterion).getCompareType();
				switch (compareType) {
				case EQ:
					sb.append(prefix + criterion.getField() + "= :" + criterion.getField() + " " + groupOp + " ");
					break;
				case NE:
					sb.append(prefix + criterion.getField() + "<> :" + criterion.getField() + " " + groupOp + " ");
					break;
				case GT:
					sb.append(prefix + criterion.getField() + "> :" + criterion.getField() + " " + groupOp + " ");
					break;
				case GTE:
					sb.append(prefix + criterion.getField() + ">= :" + criterion.getField() + " " + groupOp + " ");
					break;
				case LT:
					sb.append(prefix + criterion.getField() + "< :" + criterion.getField() + " " + groupOp + " ");
					break;
				case LTE:
					sb.append(prefix + criterion.getField() + "<= :" + criterion.getField() + " " + groupOp + " ");
					break;
				}
				break;
			}
		}
		int i = -1;
		if ((i = sb.lastIndexOf(" " + groupOp + " ")) != -1) {
			criteriaString = sb.substring(0, i);
		}
		return criteriaString;
	}

	/**
	 * 将Criteria各条件的值转换为List<Object>
	 * @param criteria
	 * @return List<Object>
	 */
	public static List<Object> getCriteriaValues(List<Criterion> criteria) {
		List<Object> criteriaValues = criteria.isEmpty() ? Collections.emptyList() : new ArrayList<Object>();
		for (Criterion criterion : criteria) {
			criteriaValues.add(criterion.getValue());
		}
		return criteriaValues;
	}

}
