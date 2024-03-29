package cn.edu.xmu.oomall.order.model.po;

import java.time.LocalDateTime;

public class OrderItemPo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.order_id
     *
     * @mbg.generated
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.shop_id
     *
     * @mbg.generated
     */
    private Long shopId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.product_id
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.onsale_id
     *
     * @mbg.generated
     */
    private Long onsaleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.quantity
     *
     * @mbg.generated
     */
    private Long quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.price
     *
     * @mbg.generated
     */
    private Long price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.discount_price
     *
     * @mbg.generated
     */
    private Long discountPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.point
     *
     * @mbg.generated
     */
    private Long point;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.coupon_activity_id
     *
     * @mbg.generated
     */
    private Long couponActivityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.coupon_id
     *
     * @mbg.generated
     */
    private Long couponId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.commented
     *
     * @mbg.generated
     */
    private Byte commented;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.creator_id
     *
     * @mbg.generated
     */
    private Long creatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.creator_name
     *
     * @mbg.generated
     */
    private String creatorName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.modifier_by
     *
     * @mbg.generated
     */
    private Long modifierBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.modifier_name
     *
     * @mbg.generated
     */
    private String modifierName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.gmt_create
     *
     * @mbg.generated
     */
    private LocalDateTime gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oomall_order_item.gmt_modified
     *
     * @mbg.generated
     */
    private LocalDateTime gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.id
     *
     * @return the value of oomall_order_item.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.id
     *
     * @param id the value for oomall_order_item.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.order_id
     *
     * @return the value of oomall_order_item.order_id
     *
     * @mbg.generated
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.order_id
     *
     * @param orderId the value for oomall_order_item.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.shop_id
     *
     * @return the value of oomall_order_item.shop_id
     *
     * @mbg.generated
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.shop_id
     *
     * @param shopId the value for oomall_order_item.shop_id
     *
     * @mbg.generated
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.product_id
     *
     * @return the value of oomall_order_item.product_id
     *
     * @mbg.generated
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.product_id
     *
     * @param productId the value for oomall_order_item.product_id
     *
     * @mbg.generated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.onsale_id
     *
     * @return the value of oomall_order_item.onsale_id
     *
     * @mbg.generated
     */
    public Long getOnsaleId() {
        return onsaleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.onsale_id
     *
     * @param onsaleId the value for oomall_order_item.onsale_id
     *
     * @mbg.generated
     */
    public void setOnsaleId(Long onsaleId) {
        this.onsaleId = onsaleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.quantity
     *
     * @return the value of oomall_order_item.quantity
     *
     * @mbg.generated
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.quantity
     *
     * @param quantity the value for oomall_order_item.quantity
     *
     * @mbg.generated
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.price
     *
     * @return the value of oomall_order_item.price
     *
     * @mbg.generated
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.price
     *
     * @param price the value for oomall_order_item.price
     *
     * @mbg.generated
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.discount_price
     *
     * @return the value of oomall_order_item.discount_price
     *
     * @mbg.generated
     */
    public Long getDiscountPrice() {
        return discountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.discount_price
     *
     * @param discountPrice the value for oomall_order_item.discount_price
     *
     * @mbg.generated
     */
    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.point
     *
     * @return the value of oomall_order_item.point
     *
     * @mbg.generated
     */
    public Long getPoint() {
        return point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.point
     *
     * @param point the value for oomall_order_item.point
     *
     * @mbg.generated
     */
    public void setPoint(Long point) {
        this.point = point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.name
     *
     * @return the value of oomall_order_item.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.name
     *
     * @param name the value for oomall_order_item.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.coupon_activity_id
     *
     * @return the value of oomall_order_item.coupon_activity_id
     *
     * @mbg.generated
     */
    public Long getCouponActivityId() {
        return couponActivityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.coupon_activity_id
     *
     * @param couponActivityId the value for oomall_order_item.coupon_activity_id
     *
     * @mbg.generated
     */
    public void setCouponActivityId(Long couponActivityId) {
        this.couponActivityId = couponActivityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.coupon_id
     *
     * @return the value of oomall_order_item.coupon_id
     *
     * @mbg.generated
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.coupon_id
     *
     * @param couponId the value for oomall_order_item.coupon_id
     *
     * @mbg.generated
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.commented
     *
     * @return the value of oomall_order_item.commented
     *
     * @mbg.generated
     */
    public Byte getCommented() {
        return commented;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.commented
     *
     * @param commented the value for oomall_order_item.commented
     *
     * @mbg.generated
     */
    public void setCommented(Byte commented) {
        this.commented = commented;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.creator_id
     *
     * @return the value of oomall_order_item.creator_id
     *
     * @mbg.generated
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.creator_id
     *
     * @param creatorId the value for oomall_order_item.creator_id
     *
     * @mbg.generated
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.creator_name
     *
     * @return the value of oomall_order_item.creator_name
     *
     * @mbg.generated
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.creator_name
     *
     * @param creatorName the value for oomall_order_item.creator_name
     *
     * @mbg.generated
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.modifier_by
     *
     * @return the value of oomall_order_item.modifier_by
     *
     * @mbg.generated
     */
    public Long getModifierBy() {
        return modifierBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.modifier_by
     *
     * @param modifierBy the value for oomall_order_item.modifier_by
     *
     * @mbg.generated
     */
    public void setModifierBy(Long modifierBy) {
        this.modifierBy = modifierBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.modifier_name
     *
     * @return the value of oomall_order_item.modifier_name
     *
     * @mbg.generated
     */
    public String getModifierName() {
        return modifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.modifier_name
     *
     * @param modifierName the value for oomall_order_item.modifier_name
     *
     * @mbg.generated
     */
    public void setModifierName(String modifierName) {
        this.modifierName = modifierName == null ? null : modifierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.gmt_create
     *
     * @return the value of oomall_order_item.gmt_create
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.gmt_create
     *
     * @param gmtCreate the value for oomall_order_item.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oomall_order_item.gmt_modified
     *
     * @return the value of oomall_order_item.gmt_modified
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oomall_order_item.gmt_modified
     *
     * @param gmtModified the value for oomall_order_item.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}