package com.zufe.mychat.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LtlbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LtlbExample() {
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

        public Criteria andLtlbIdIsNull() {
            addCriterion("ltlb_id is null");
            return (Criteria) this;
        }

        public Criteria andLtlbIdIsNotNull() {
            addCriterion("ltlb_id is not null");
            return (Criteria) this;
        }

        public Criteria andLtlbIdEqualTo(Integer value) {
            addCriterion("ltlb_id =", value, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdNotEqualTo(Integer value) {
            addCriterion("ltlb_id <>", value, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdGreaterThan(Integer value) {
            addCriterion("ltlb_id >", value, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ltlb_id >=", value, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdLessThan(Integer value) {
            addCriterion("ltlb_id <", value, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdLessThanOrEqualTo(Integer value) {
            addCriterion("ltlb_id <=", value, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdIn(List<Integer> values) {
            addCriterion("ltlb_id in", values, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdNotIn(List<Integer> values) {
            addCriterion("ltlb_id not in", values, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdBetween(Integer value1, Integer value2) {
            addCriterion("ltlb_id between", value1, value2, "ltlbId");
            return (Criteria) this;
        }

        public Criteria andLtlbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ltlb_id not between", value1, value2, "ltlbId");
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

        public Criteria andTouserIsNull() {
            addCriterion("touser is null");
            return (Criteria) this;
        }

        public Criteria andTouserIsNotNull() {
            addCriterion("touser is not null");
            return (Criteria) this;
        }

        public Criteria andTouserEqualTo(String value) {
            addCriterion("touser =", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotEqualTo(String value) {
            addCriterion("touser <>", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThan(String value) {
            addCriterion("touser >", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThanOrEqualTo(String value) {
            addCriterion("touser >=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThan(String value) {
            addCriterion("touser <", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThanOrEqualTo(String value) {
            addCriterion("touser <=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLike(String value) {
            addCriterion("touser like", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotLike(String value) {
            addCriterion("touser not like", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserIn(List<String> values) {
            addCriterion("touser in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotIn(List<String> values) {
            addCriterion("touser not in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserBetween(String value1, String value2) {
            addCriterion("touser between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotBetween(String value1, String value2) {
            addCriterion("touser not between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andMyreadIsNull() {
            addCriterion("myread is null");
            return (Criteria) this;
        }

        public Criteria andMyreadIsNotNull() {
            addCriterion("myread is not null");
            return (Criteria) this;
        }

        public Criteria andMyreadEqualTo(Byte value) {
            addCriterion("myread =", value, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadNotEqualTo(Byte value) {
            addCriterion("myread <>", value, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadGreaterThan(Byte value) {
            addCriterion("myread >", value, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadGreaterThanOrEqualTo(Byte value) {
            addCriterion("myread >=", value, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadLessThan(Byte value) {
            addCriterion("myread <", value, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadLessThanOrEqualTo(Byte value) {
            addCriterion("myread <=", value, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadIn(List<Byte> values) {
            addCriterion("myread in", values, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadNotIn(List<Byte> values) {
            addCriterion("myread not in", values, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadBetween(Byte value1, Byte value2) {
            addCriterion("myread between", value1, value2, "myread");
            return (Criteria) this;
        }

        public Criteria andMyreadNotBetween(Byte value1, Byte value2) {
            addCriterion("myread not between", value1, value2, "myread");
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