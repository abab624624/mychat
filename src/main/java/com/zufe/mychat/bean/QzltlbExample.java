package com.zufe.mychat.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QzltlbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QzltlbExample() {
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

        public Criteria andQzltlbIdIsNull() {
            addCriterion("qzltlb_id is null");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdIsNotNull() {
            addCriterion("qzltlb_id is not null");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdEqualTo(Integer value) {
            addCriterion("qzltlb_id =", value, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdNotEqualTo(Integer value) {
            addCriterion("qzltlb_id <>", value, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdGreaterThan(Integer value) {
            addCriterion("qzltlb_id >", value, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qzltlb_id >=", value, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdLessThan(Integer value) {
            addCriterion("qzltlb_id <", value, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdLessThanOrEqualTo(Integer value) {
            addCriterion("qzltlb_id <=", value, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdIn(List<Integer> values) {
            addCriterion("qzltlb_id in", values, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdNotIn(List<Integer> values) {
            addCriterion("qzltlb_id not in", values, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdBetween(Integer value1, Integer value2) {
            addCriterion("qzltlb_id between", value1, value2, "qzltlbId");
            return (Criteria) this;
        }

        public Criteria andQzltlbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("qzltlb_id not between", value1, value2, "qzltlbId");
            return (Criteria) this;
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andSjIsNull() {
            addCriterion("sj is null");
            return (Criteria) this;
        }

        public Criteria andSjIsNotNull() {
            addCriterion("sj is not null");
            return (Criteria) this;
        }

        public Criteria andSjEqualTo(Date value) {
            addCriterion("sj =", value, "sj");
            return (Criteria) this;
        }

        public Criteria andSjNotEqualTo(Date value) {
            addCriterion("sj <>", value, "sj");
            return (Criteria) this;
        }

        public Criteria andSjGreaterThan(Date value) {
            addCriterion("sj >", value, "sj");
            return (Criteria) this;
        }

        public Criteria andSjGreaterThanOrEqualTo(Date value) {
            addCriterion("sj >=", value, "sj");
            return (Criteria) this;
        }

        public Criteria andSjLessThan(Date value) {
            addCriterion("sj <", value, "sj");
            return (Criteria) this;
        }

        public Criteria andSjLessThanOrEqualTo(Date value) {
            addCriterion("sj <=", value, "sj");
            return (Criteria) this;
        }

        public Criteria andSjIn(List<Date> values) {
            addCriterion("sj in", values, "sj");
            return (Criteria) this;
        }

        public Criteria andSjNotIn(List<Date> values) {
            addCriterion("sj not in", values, "sj");
            return (Criteria) this;
        }

        public Criteria andSjBetween(Date value1, Date value2) {
            addCriterion("sj between", value1, value2, "sj");
            return (Criteria) this;
        }

        public Criteria andSjNotBetween(Date value1, Date value2) {
            addCriterion("sj not between", value1, value2, "sj");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andMyqzreadIsNull() {
            addCriterion("myqzread is null");
            return (Criteria) this;
        }

        public Criteria andMyqzreadIsNotNull() {
            addCriterion("myqzread is not null");
            return (Criteria) this;
        }

        public Criteria andMyqzreadEqualTo(Boolean value) {
            addCriterion("myqzread =", value, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadNotEqualTo(Boolean value) {
            addCriterion("myqzread <>", value, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadGreaterThan(Boolean value) {
            addCriterion("myqzread >", value, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("myqzread >=", value, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadLessThan(Boolean value) {
            addCriterion("myqzread <", value, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadLessThanOrEqualTo(Boolean value) {
            addCriterion("myqzread <=", value, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadIn(List<Boolean> values) {
            addCriterion("myqzread in", values, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadNotIn(List<Boolean> values) {
            addCriterion("myqzread not in", values, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadBetween(Boolean value1, Boolean value2) {
            addCriterion("myqzread between", value1, value2, "myqzread");
            return (Criteria) this;
        }

        public Criteria andMyqzreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("myqzread not between", value1, value2, "myqzread");
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