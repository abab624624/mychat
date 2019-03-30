package com.zufe.mychat.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QzusersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QzusersExample() {
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

        public Criteria andQzusersIdIsNull() {
            addCriterion("qzusers_id is null");
            return (Criteria) this;
        }

        public Criteria andQzusersIdIsNotNull() {
            addCriterion("qzusers_id is not null");
            return (Criteria) this;
        }

        public Criteria andQzusersIdEqualTo(String value) {
            addCriterion("qzusers_id =", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdNotEqualTo(String value) {
            addCriterion("qzusers_id <>", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdGreaterThan(String value) {
            addCriterion("qzusers_id >", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdGreaterThanOrEqualTo(String value) {
            addCriterion("qzusers_id >=", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdLessThan(String value) {
            addCriterion("qzusers_id <", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdLessThanOrEqualTo(String value) {
            addCriterion("qzusers_id <=", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdLike(String value) {
            addCriterion("qzusers_id like", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdNotLike(String value) {
            addCriterion("qzusers_id not like", value, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdIn(List<String> values) {
            addCriterion("qzusers_id in", values, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdNotIn(List<String> values) {
            addCriterion("qzusers_id not in", values, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdBetween(String value1, String value2) {
            addCriterion("qzusers_id between", value1, value2, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andQzusersIdNotBetween(String value1, String value2) {
            addCriterion("qzusers_id not between", value1, value2, "qzusersId");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNull() {
            addCriterion("join_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("join_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(Date value) {
            addCriterion("join_time =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(Date value) {
            addCriterion("join_time <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(Date value) {
            addCriterion("join_time >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("join_time >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(Date value) {
            addCriterion("join_time <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(Date value) {
            addCriterion("join_time <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<Date> values) {
            addCriterion("join_time in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<Date> values) {
            addCriterion("join_time not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(Date value1, Date value2) {
            addCriterion("join_time between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(Date value1, Date value2) {
            addCriterion("join_time not between", value1, value2, "joinTime");
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