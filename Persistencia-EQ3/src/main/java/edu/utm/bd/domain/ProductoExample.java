package edu.utm.bd.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public ProductoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
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

        public Criteria andIdProductoIsNull() {
            addCriterion("id_producto is null");
            return (Criteria) this;
        }

        public Criteria andIdProductoIsNotNull() {
            addCriterion("id_producto is not null");
            return (Criteria) this;
        }

        public Criteria andIdProductoEqualTo(Integer value) {
            addCriterion("id_producto =", value, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoNotEqualTo(Integer value) {
            addCriterion("id_producto <>", value, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoGreaterThan(Integer value) {
            addCriterion("id_producto >", value, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_producto >=", value, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoLessThan(Integer value) {
            addCriterion("id_producto <", value, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoLessThanOrEqualTo(Integer value) {
            addCriterion("id_producto <=", value, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoIn(List<Integer> values) {
            addCriterion("id_producto in", values, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoNotIn(List<Integer> values) {
            addCriterion("id_producto not in", values, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoBetween(Integer value1, Integer value2) {
            addCriterion("id_producto between", value1, value2, "idProducto");
            return (Criteria) this;
        }

        public Criteria andIdProductoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_producto not between", value1, value2, "idProducto");
            return (Criteria) this;
        }

        public Criteria andSkuIsNull() {
            addCriterion("SKU is null");
            return (Criteria) this;
        }

        public Criteria andSkuIsNotNull() {
            addCriterion("SKU is not null");
            return (Criteria) this;
        }

        public Criteria andSkuEqualTo(String value) {
            addCriterion("SKU =", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotEqualTo(String value) {
            addCriterion("SKU <>", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThan(String value) {
            addCriterion("SKU >", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("SKU >=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThan(String value) {
            addCriterion("SKU <", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("SKU <=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLike(String value) {
            addCriterion("SKU like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotLike(String value) {
            addCriterion("SKU not like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuIn(List<String> values) {
            addCriterion("SKU in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotIn(List<String> values) {
            addCriterion("SKU not in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuBetween(String value1, String value2) {
            addCriterion("SKU between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("SKU not between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andTipoIsNull() {
            addCriterion("tipo is null");
            return (Criteria) this;
        }

        public Criteria andTipoIsNotNull() {
            addCriterion("tipo is not null");
            return (Criteria) this;
        }

        public Criteria andTipoEqualTo(String value) {
            addCriterion("tipo =", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoNotEqualTo(String value) {
            addCriterion("tipo <>", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoGreaterThan(String value) {
            addCriterion("tipo >", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoGreaterThanOrEqualTo(String value) {
            addCriterion("tipo >=", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoLessThan(String value) {
            addCriterion("tipo <", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoLessThanOrEqualTo(String value) {
            addCriterion("tipo <=", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoLike(String value) {
            addCriterion("tipo like", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoNotLike(String value) {
            addCriterion("tipo not like", value, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoIn(List<String> values) {
            addCriterion("tipo in", values, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoNotIn(List<String> values) {
            addCriterion("tipo not in", values, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoBetween(String value1, String value2) {
            addCriterion("tipo between", value1, value2, "tipo");
            return (Criteria) this;
        }

        public Criteria andTipoNotBetween(String value1, String value2) {
            addCriterion("tipo not between", value1, value2, "tipo");
            return (Criteria) this;
        }

        public Criteria andMarcaIsNull() {
            addCriterion("marca is null");
            return (Criteria) this;
        }

        public Criteria andMarcaIsNotNull() {
            addCriterion("marca is not null");
            return (Criteria) this;
        }

        public Criteria andMarcaEqualTo(String value) {
            addCriterion("marca =", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotEqualTo(String value) {
            addCriterion("marca <>", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaGreaterThan(String value) {
            addCriterion("marca >", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaGreaterThanOrEqualTo(String value) {
            addCriterion("marca >=", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaLessThan(String value) {
            addCriterion("marca <", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaLessThanOrEqualTo(String value) {
            addCriterion("marca <=", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaLike(String value) {
            addCriterion("marca like", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotLike(String value) {
            addCriterion("marca not like", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaIn(List<String> values) {
            addCriterion("marca in", values, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotIn(List<String> values) {
            addCriterion("marca not in", values, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaBetween(String value1, String value2) {
            addCriterion("marca between", value1, value2, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotBetween(String value1, String value2) {
            addCriterion("marca not between", value1, value2, "marca");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraIsNull() {
            addCriterion("precio_compra is null");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraIsNotNull() {
            addCriterion("precio_compra is not null");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraEqualTo(Double value) {
            addCriterion("precio_compra =", value, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraNotEqualTo(Double value) {
            addCriterion("precio_compra <>", value, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraGreaterThan(Double value) {
            addCriterion("precio_compra >", value, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraGreaterThanOrEqualTo(Double value) {
            addCriterion("precio_compra >=", value, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraLessThan(Double value) {
            addCriterion("precio_compra <", value, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraLessThanOrEqualTo(Double value) {
            addCriterion("precio_compra <=", value, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraIn(List<Double> values) {
            addCriterion("precio_compra in", values, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraNotIn(List<Double> values) {
            addCriterion("precio_compra not in", values, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraBetween(Double value1, Double value2) {
            addCriterion("precio_compra between", value1, value2, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioCompraNotBetween(Double value1, Double value2) {
            addCriterion("precio_compra not between", value1, value2, "precioCompra");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaIsNull() {
            addCriterion("precio_venta is null");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaIsNotNull() {
            addCriterion("precio_venta is not null");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaEqualTo(Double value) {
            addCriterion("precio_venta =", value, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaNotEqualTo(Double value) {
            addCriterion("precio_venta <>", value, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaGreaterThan(Double value) {
            addCriterion("precio_venta >", value, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaGreaterThanOrEqualTo(Double value) {
            addCriterion("precio_venta >=", value, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaLessThan(Double value) {
            addCriterion("precio_venta <", value, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaLessThanOrEqualTo(Double value) {
            addCriterion("precio_venta <=", value, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaIn(List<Double> values) {
            addCriterion("precio_venta in", values, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaNotIn(List<Double> values) {
            addCriterion("precio_venta not in", values, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaBetween(Double value1, Double value2) {
            addCriterion("precio_venta between", value1, value2, "precioVenta");
            return (Criteria) this;
        }

        public Criteria andPrecioVentaNotBetween(Double value1, Double value2) {
            addCriterion("precio_venta not between", value1, value2, "precioVenta");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table producto
     *
     * @mbggenerated do_not_delete_during_merge Wed Apr 25 18:12:03 CDT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
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