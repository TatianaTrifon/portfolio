package com.practiceUni.shoppingWeb.domain;

import java.sql.Blob;
import java.util.Base64;
import java.util.Objects;

public class Product {

  private Integer id;

  private String name;

  private String category;

  private String size;

  private String color;

  private Integer quantity;

  private byte[] image;

  public Product(Integer id, String name, String category, String size, String color, Integer quantity, byte[] image) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.size = size;
    this.color = color;
    this.quantity = quantity;
    this.image = image;
  }

  public Product(
      Integer id, String name, String category, String size, String color, Integer quantity) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.size = size;
    this.color = color;
    this.quantity = quantity;
  }


  public Product(String name, String category, String size, String color, Integer quantity) {
    this.name = name;
    this.category = category;
    this.size = size;
    this.color = color;
    this.quantity = quantity;
  }

  public Product() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public String getImageBase64() {
    if (image == null || image.length == 0) {
      return null;
    }
    return Base64.getEncoder().encodeToString(image);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id)
        && Objects.equals(name, product.name)
        && Objects.equals(category, product.category)
        && Objects.equals(size, product.size)
        && Objects.equals(color, product.color)
        && Objects.equals(quantity, product.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, category, size, color, quantity);
  }
}
