package com.zufe.mychat.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QzxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QzxxExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQzidIsNull() {
            addCriterion("qzid is null");
            return (Criteria) this;
        }

        public Criteria andQzidIsNotNull() {
            addCriterion("qzid is not null");
            return (Criteria) this;
        }

        public Criteria andQzidEqualTo(String value) {
            addCriterion("qzid =", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidNotEqualTo(String value) {
            addCriterion("qzid <>", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidGreaterThan(String value) {
            addCriterion("qzid >", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidGreaterThanOrEqualTo(String value) {
            addCriterion("qzid >=", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidLessThan(String value) {
            addCriterion("qzid <", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidLessThanOrEqualTo(String value) {
            addCriterion("qzid <=", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidLike(String value) {
            addCriterion("qzid like", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidNotLike(String value) {
            addCriterion("qzid not like", value, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidIn(List<String> values) {
            addCriterion("qzid in", values, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidNotIn(List<String> values) {
            addCriterion("qzid not in", values, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidBetween(String value1, String value2) {
            addCriterion("qzid between", value1, value2, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzidNotBetween(String value1, String value2) {
            addCriterion("qzid not between", value1, value2, "qzid");
            return (Criteria) this;
        }

        public Criteria andQzxxIdIsNull() {
            addCriterion("qzxx_id is null");
            return (Criteria) this;
        }

        public Criteria andQzxxIdIsNotNull() {
            addCriterion("qzxx_id is not null");
            return (Criteria) this;
        }

        public Criteria andQzxxIdEqualTo(Integer value) {
            addCriterion("qzxx_id =", value, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdNotEqualTo(Integer value) {
            addCriterion("qzxx_id <>", value, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdGreaterThan(Integer value) {
            addCriterion("qzxx_id >", value, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qzxx_id >=", value, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdLessThan(Integer value) {
            addCriterion("qzxx_id <", value, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdLessThanOrEqualTo(Integer value) {
            addCriterion("qzxx_id <=", value, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdIn(List<Integer> values) {
            addCriterion("qzxx_id in", values, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdNotIn(List<Integer> values) {
            addCriterion("qzxx_id not in", values, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdBetween(Integer value1, Integer value2) {
            addCriterion("qzxx_id between", value1, value2, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQzxxIdNotBetween(Integer value1, Integer value2) {
            addCriterion("qzxx_id not between", value1, value2, "qzxxId");
            return (Criteria) this;
        }

        public Criteria andQznameIsNull() {
            addCriterion("qzname is null");
            return (Criteria) this;
        }

        public Criteria andQznameIsNotNull() {
            addCriterion("qzname is not null");
            return (Criteria) this;
        }

        public Criteria andQznameEqualTo(String value) {
            addCriterion("qzname =", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameNotEqualTo(String value) {
            addCriterion("qzname <>", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameGreaterThan(String value) {
            addCriterion("qzname >", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameGreaterThanOrEqualTo(String value) {
            addCriterion("qzname >=", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameLessThan(String value) {
            addCriterion("qzname <", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameLessThanOrEqualTo(String value) {
            addCriterion("qzname <=", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameLike(String value) {
            addCriterion("qzname like", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameNotLike(String value) {
            addCriterion("qzname not like", value, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameIn(List<String> values) {
            addCriterion("qzname in", values, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameNotIn(List<String> values) {
            addCriterion("qzname not in", values, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameBetween(String value1, String value2) {
            addCriterion("qzname between", value1, value2, "qzname");
            return (Criteria) this;
        }

        public Criteria andQznameNotBetween(String value1, String value2) {
            addCriterion("qzname not between", value1, value2, "qzname");
            return (Criteria) this;
        }

        public Criteria andQzcreaterIsNull() {
            addCriterion("qzcreater is null");
            return (Criteria) this;
        }

        public Criteria andQzcreaterIsNotNull() {
            addCriterion("qzcreater is not null");
            return (Criteria) this;
        }

        public Criteria andQzcreaterEqualTo(String value) {
            addCriterion("qzcreater =", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterNotEqualTo(String value) {
            addCriterion("qzcreater <>", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterGreaterThan(String value) {
            addCriterion("qzcreater >", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterGreaterThanOrEqualTo(String value) {
            addCriterion("qzcreater >=", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterLessThan(String value) {
            addCriterion("qzcreater <", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterLessThanOrEqualTo(String value) {
            addCriterion("qzcreater <=", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterLike(String value) {
            addCriterion("qzcreater like", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterNotLike(String value) {
            addCriterion("qzcreater not like", value, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterIn(List<String> values) {
            addCriterion("qzcreater in", values, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterNotIn(List<String> values) {
            addCriterion("qzcreater not in", values, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterBetween(String value1, String value2) {
            addCriterion("qzcreater between", value1, value2, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andQzcreaterNotBetween(String value1, String value2) {
            addCriterion("qzcreater not between", value1, value2, "qzcreater");
            return (Criteria) this;
        }

        public Criteria andYxIsNull() {
            addCriterion("yx is null");
            return (Criteria) this;
        }

        public Criteria andYxIsNotNull() {
            addCriterion("yx is not null");
            return (Criteria) this;
        }

        public Criteria andYxEqualTo(Boolean value) {
            addCriterion("yx =", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotEqualTo(Boolean value) {
            addCriterion("yx <>", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThan(Boolean value) {
            addCriterion("yx >", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThanOrEqualTo(Boolean value) {
            addCriterion("yx >=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThan(Boolean value) {
            addCriterion("yx <", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThanOrEqualTo(Boolean value) {
            addCriterion("yx <=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxIn(List<Boolean> values) {
            addCriterion("yx in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotIn(List<Boolean> values) {
            addCriterion("yx not in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxBetween(Boolean value1, Boolean value2) {
            addCriterion("yx between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotBetween(Boolean value1, Boolean value2) {
            addCriterion("yx not between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}