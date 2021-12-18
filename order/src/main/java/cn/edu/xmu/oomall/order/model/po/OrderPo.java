package cn.edu.xmu.oomall.order.model.po;

import java.time.LocalDateTime;

public class OrderPo {
    @Override
    public String toString() {
        return "OrderPo{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", shopId=" + shopId +
                ", orderSn='" + orderSn + '\'' +
                ", pid=" + pid +
                ", consignee='" + consignee + '\'' +
                ", regionId=" + regionId +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", message='" + message + '\'' +
                ", advancesaleId=" + advancesaleId +
                ", grouponId=" + grouponId +
                ", expressFee=" + expressFee +
                ", discountPrice=" + discountPrice +
                ", originPrice=" + originPrice +
                ", point=" + point +
                ", confirmTime=" + confirmTime +
                ", shipmentSn='" + shipmentSn + '\'' +
                ", state=" + state +
                ", beDeleted=" + beDeleted +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", modifierId=" + modifierId +
                ", modifierName='" + modifierName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.customer_id
     *
     * @mbg.generated
     */
    private Long customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.shop_id
     *
     * @mbg.generated
     */
    private Long shopId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.order_sn
     *
     * @mbg.generated
     */
    private String orderSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.pid
     *
     * @mbg.generated
     */
    private Long pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.consignee
     *
     * @mbg.generated
     */
    private String consignee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.region_id
     *
     * @mbg.generated
     */
    private Long regionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.message
     *
     * @mbg.generated
     */
    private String message;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.advancesale_id
     *
     * @mbg.generated
     */
    private Long advancesaleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.groupon_id
     *
     * @mbg.generated
     */
    private Long grouponId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.express_fee
     *
     * @mbg.generated
     */
    private Long expressFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.discount_price
     *
     * @mbg.generated
     */
    private Long discountPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.origin_price
     *
     * @mbg.generated
     */
    private Long originPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.point
     *
     * @mbg.generated
     */
    private Long point;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.confirm_time
     *
     * @mbg.generated
     */
    private LocalDateTime confirmTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.shipment_sn
     *
     * @mbg.generated
     */
    private String shipmentSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.be_deleted
     *
     * @mbg.generated
     */
    private Byte beDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.creator_id
     *
     * @mbg.generated
     */
    private Long creatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.creator_name
     *
     * @mbg.generated
     */
    private String creatorName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.modifier_id
     *
     * @mbg.generated
     */
    private Long modifierId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.modifier_name
     *
     * @mbg.generated
     */
    private String modifierName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.gmt_create
     *
     * @mbg.generated
     */
    private LocalDateTime gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order.gmt_modified
     *
     * @mbg.generated
     */
    private LocalDateTime gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.id
     *
     * @return the value of oomall_order.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.id
     *
     * @param id the value for oomall_order.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.customer_id
     *
     * @return the value of oomall_order.customer_id
     *
     * @mbg.generated
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.customer_id
     *
     * @param customerId the value for oomall_order.customer_id
     *
     * @mbg.generated
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.shop_id
     *
     * @return the value of oomall_order.shop_id
     *
     * @mbg.generated
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.shop_id
     *
     * @param shopId the value for oomall_order.shop_id
     *
     * @mbg.generated
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.order_sn
     *
     * @return the value of oomall_order.order_sn
     *
     * @mbg.generated
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.order_sn
     *
     * @param orderSn the value for oomall_order.order_sn
     *
     * @mbg.generated
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.pid
     *
     * @return the value of oomall_order.pid
     *
     * @mbg.generated
     */
    public Long getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.pid
     *
     * @param pid the value for oomall_order.pid
     *
     * @mbg.generated
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.consignee
     *
     * @return the value of oomall_order.consignee
     *
     * @mbg.generated
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.consignee
     *
     * @param consignee the value for oomall_order.consignee
     *
     * @mbg.generated
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.region_id
     *
     * @return the value of oomall_order.region_id
     *
     * @mbg.generated
     */
    public Long getRegionId() {
        return regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.region_id
     *
     * @param regionId the value for oomall_order.region_id
     *
     * @mbg.generated
     */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.address
     *
     * @return the value of oomall_order.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.address
     *
     * @param address the value for oomall_order.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.mobile
     *
     * @return the value of oomall_order.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.mobile
     *
     * @param mobile the value for oomall_order.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.message
     *
     * @return the value of oomall_order.message
     *
     * @mbg.generated
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.message
     *
     * @param message the value for oomall_order.message
     *
     * @mbg.generated
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.advancesale_id
     *
     * @return the value of oomall_order.advancesale_id
     *
     * @mbg.generated
     */
    public Long getAdvancesaleId() {
        return advancesaleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.advancesale_id
     *
     * @param advancesaleId the value for oomall_order.advancesale_id
     *
     * @mbg.generated
     */
    public void setAdvancesaleId(Long advancesaleId) {
        this.advancesaleId = advancesaleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.groupon_id
     *
     * @return the value of oomall_order.groupon_id
     *
     * @mbg.generated
     */
    public Long getGrouponId() {
        return grouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.groupon_id
     *
     * @param grouponId the value for oomall_order.groupon_id
     *
     * @mbg.generated
     */
    public void setGrouponId(Long grouponId) {
        this.grouponId = grouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.express_fee
     *
     * @return the value of oomall_order.express_fee
     *
     * @mbg.generated
     */
    public Long getExpressFee() {
        return expressFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.express_fee
     *
     * @param expressFee the value for oomall_order.express_fee
     *
     * @mbg.generated
     */
    public void setExpressFee(Long expressFee) {
        this.expressFee = expressFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.discount_price
     *
     * @return the value of oomall_order.discount_price
     *
     * @mbg.generated
     */
    public Long getDiscountPrice() {
        return discountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.discount_price
     *
     * @param discountPrice the value for oomall_order.discount_price
     *
     * @mbg.generated
     */
    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.origin_price
     *
     * @return the value of oomall_order.origin_price
     *
     * @mbg.generated
     */
    public Long getOriginPrice() {
        return originPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.origin_price
     *
     * @param originPrice the value for oomall_order.origin_price
     *
     * @mbg.generated
     */
    public void setOriginPrice(Long originPrice) {
        this.originPrice = originPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.point
     *
     * @return the value of oomall_order.point
     *
     * @mbg.generated
     */
    public Long getPoint() {
        return point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.point
     *
     * @param point the value for oomall_order.point
     *
     * @mbg.generated
     */
    public void setPoint(Long point) {
        this.point = point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.confirm_time
     *
     * @return the value of oomall_order.confirm_time
     *
     * @mbg.generated
     */
    public LocalDateTime getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.confirm_time
     *
     * @param confirmTime the value for oomall_order.confirm_time
     *
     * @mbg.generated
     */
    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.shipment_sn
     *
     * @return the value of oomall_order.shipment_sn
     *
     * @mbg.generated
     */
    public String getShipmentSn() {
        return shipmentSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.shipment_sn
     *
     * @param shipmentSn the value for oomall_order.shipment_sn
     *
     * @mbg.generated
     */
    public void setShipmentSn(String shipmentSn) {
        this.shipmentSn = shipmentSn == null ? null : shipmentSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.state
     *
     * @return the value of oomall_order.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.state
     *
     * @param state the value for oomall_order.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.be_deleted
     *
     * @return the value of oomall_order.be_deleted
     *
     * @mbg.generated
     */
    public Byte getBeDeleted() {
        return beDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.be_deleted
     *
     * @param beDeleted the value for oomall_order.be_deleted
     *
     * @mbg.generated
     */
    public void setBeDeleted(Byte beDeleted) {
        this.beDeleted = beDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.creator_id
     *
     * @return the value of oomall_order.creator_id
     *
     * @mbg.generated
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.creator_id
     *
     * @param creatorId the value for oomall_order.creator_id
     *
     * @mbg.generated
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.creator_name
     *
     * @return the value of oomall_order.creator_name
     *
     * @mbg.generated
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.creator_name
     *
     * @param creatorName the value for oomall_order.creator_name
     *
     * @mbg.generated
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.modifier_id
     *
     * @return the value of oomall_order.modifier_id
     *
     * @mbg.generated
     */
    public Long getModifierId() {
        return modifierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.modifier_id
     *
     * @param modifierId the value for oomall_order.modifier_id
     *
     * @mbg.generated
     */
    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.modifier_name
     *
     * @return the value of oomall_order.modifier_name
     *
     * @mbg.generated
     */
    public String getModifierName() {
        return modifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.modifier_name
     *
     * @param modifierName the value for oomall_order.modifier_name
     *
     * @mbg.generated
     */
    public void setModifierName(String modifierName) {
        this.modifierName = modifierName == null ? null : modifierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.gmt_create
     *
     * @return the value of oomall_order.gmt_create
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.gmt_create
     *
     * @param gmtCreate the value for oomall_order.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order.gmt_modified
     *
     * @return the value of oomall_order.gmt_modified
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order.gmt_modified
     *
     * @param gmtModified the value for oomall_order.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}