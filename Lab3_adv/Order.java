class Order {
    private String id;
    private String userId;
    private String productId;

    // Constructor and Getters
    public Order(String id, String userId, String productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getProductId() { return productId; }
}