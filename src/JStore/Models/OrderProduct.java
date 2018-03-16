package JStore.Models;

import java.io.Serializable;

public class OrderProduct implements Serializable{

    public Product Product;
    public Order orderProduct;
    public Integer Quantity;
    public Float totalPrice;

    public OrderProduct(JStore.Models.Product product, Order orderProduct, Integer quantity, Float totalPrice) {
        this.Product = product;
        this.orderProduct = orderProduct;
        this.Quantity = quantity;
        this.totalPrice = totalPrice;
    }



    public Double getTotalPrice(){
        return Double.valueOf(Quantity * totalPrice);
    }
    public String getStringTotalPrice(){
        return String.valueOf( Double.valueOf(Quantity * totalPrice));
    }
    public String getStringQuantity() {
        return String.valueOf(Quantity);
    }

    public String getProductName(){return Product.getProductName();}

    public JStore.Models.Product getProduct() {
        return Product;
    }

    public void setProduct(JStore.Models.Product product) {
        Product = product;
    }

    public Order getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Order orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
