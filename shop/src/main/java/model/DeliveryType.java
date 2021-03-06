package model;

public class DeliveryType {

    private Long id;
    private Long orderId;
    private String name;

    public DeliveryType() {
    }

    public DeliveryType(Long id, Long orderId, String name) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
