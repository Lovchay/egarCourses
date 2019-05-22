package model;

public class Product {

    private Long Id;
    private String description;
    private String name;
    private String existence;

    public Product() {
    }

    public Product(Long id, String description, String name, String existence) {
        Id = id;
        this.description = description;
        this.name = name;
        this.existence = existence;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExistence() {
        return existence;
    }

    public void setExistence(String existence) {
        this.existence = existence;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", existence='" + existence + '\'' +
                '}';
    }
}
