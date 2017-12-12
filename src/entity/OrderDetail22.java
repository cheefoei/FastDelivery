package entity;

import java.io.Serializable;

/**
 *
 * @author cheefoei's
 */
public class OrderDetail22 implements Serializable {

    private Order22 order;
    private Food food;
    private int qty;
    private String remark; //Let customer to remark no egg? no spicy?

    public OrderDetail22() {
    }

    public OrderDetail22(Order22 order, Food food, int qty, String remark) {
        this.order = order;
        this.food = food;
        this.qty = qty;
        this.remark = remark;
    }

    public Order22 getOrder() {
        return order;
    }

    public void setOrder(Order22 order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
