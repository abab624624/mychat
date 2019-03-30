package com.zufe.mychat.bean;

import java.util.ArrayList;
import java.util.List;

public class FriendsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendsExample() {
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

        public Criteria andUser1IsNull() {
            addCriterion("user1 is null");
            return (Criteria) this;
        }

        public Criteria andUser1IsNotNull() {
            addCriterion("user1 is not null");
            return (Criteria) this;
        }

        public Criteria andUser1EqualTo(String value) {
            addCriterion("user1 =", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1NotEqualTo(String value) {
            addCriterion("user1 <>", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1GreaterThan(String value) {
            addCriterion("user1 >", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1GreaterThanOrEqualTo(String value) {
            addCriterion("user1 >=", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1LessThan(String value) {
            addCriterion("user1 <", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1LessThanOrEqualTo(String value) {
            addCriterion("user1 <=", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1Like(String value) {
            addCriterion("user1 like", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1NotLike(String value) {
            addCriterion("user1 not like", value, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1In(List<String> values) {
            addCriterion("user1 in", values, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1NotIn(List<String> values) {
            addCriterion("user1 not in", values, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1Between(String value1, String value2) {
            addCriterion("user1 between", value1, value2, "user1");
            return (Criteria) this;
        }

        public Criteria andUser1NotBetween(String value1, String value2) {
            addCriterion("user1 not between", value1, value2, "user1");
            return (Criteria) this;
        }

        public Criteria andUser2IsNull() {
            addCriterion("user2 is null");
            return (Criteria) this;
        }

        public Criteria andUser2IsNotNull() {
            addCriterion("user2 is not null");
            return (Criteria) this;
        }

        public Criteria andUser2EqualTo(String value) {
            addCriterion("user2 =", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2NotEqualTo(String value) {
            addCriterion("user2 <>", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2GreaterThan(String value) {
            addCriterion("user2 >", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2GreaterThanOrEqualTo(String value) {
            addCriterion("user2 >=", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2LessThan(String value) {
            addCriterion("user2 <", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2LessThanOrEqualTo(String value) {
            addCriterion("user2 <=", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2Like(String value) {
            addCriterion("user2 like", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2NotLike(String value) {
            addCriterion("user2 not like", value, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2In(List<String> values) {
            addCriterion("user2 in", values, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2NotIn(List<String> values) {
            addCriterion("user2 not in", values, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2Between(String value1, String value2) {
            addCriterion("user2 between", value1, value2, "user2");
            return (Criteria) this;
        }

        public Criteria andUser2NotBetween(String value1, String value2) {
            addCriterion("user2 not between", value1, value2, "user2");
            return (Criteria) this;
        }

        public Criteria andFriendsIdIsNull() {
            addCriterion("friends_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendsIdIsNotNull() {
            addCriterion("friends_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendsIdEqualTo(String value) {
            addCriterion("friends_id =", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotEqualTo(String value) {
            addCriterion("friends_id <>", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdGreaterThan(String value) {
            addCriterion("friends_id >", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdGreaterThanOrEqualTo(String value) {
            addCriterion("friends_id >=", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdLessThan(String value) {
            addCriterion("friends_id <", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdLessThanOrEqualTo(String value) {
            addCriterion("friends_id <=", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdLike(String value) {
            addCriterion("friends_id like", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotLike(String value) {
            addCriterion("friends_id not like", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdIn(List<String> values) {
            addCriterion("friends_id in", values, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotIn(List<String> values) {
            addCriterion("friends_id not in", values, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdBetween(String value1, String value2) {
            addCriterion("friends_id between", value1, value2, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotBetween(String value1, String value2) {
            addCriterion("friends_id not between", value1, value2, "friendsId");
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