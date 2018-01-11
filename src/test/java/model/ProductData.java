package model;

import java.util.Objects;

public class ProductData {

   private String name;
   private String brandName;
   private String sku;
   private String label;
   private Integer priceMultiplyCount;
   private Integer quantity;
   private Integer price;
   private String rusSize;

   public ProductData() {
   }

   public ProductData withName(String name) {
      this.name = name.toLowerCase();
      return this;
   }

   public ProductData withBrandName(String brandName) {
      this.brandName = brandName.toLowerCase();
      return this;
   }

   public ProductData withSku(String sku) {
      this.sku = sku;
      return this;
   }

   public ProductData withLabel(String label) {
      this.label = label;
      return this;
   }

   public ProductData withPriceMultiplyCount(Integer priceMultiplyCount) {
      this.priceMultiplyCount = priceMultiplyCount;
      return this;
   }

   public ProductData withQuantity(Integer count) {
      this.quantity = count;
      return this;
   }

   public ProductData withPrice(Integer price) {
      this.price = price;
      return this;
   }

   public ProductData withRusSize(String rusSize) {
      this.rusSize = rusSize;
      return this;
   }

   public String getName() {
      return name;
   }

   public String getBrandName() {
      return brandName;
   }

   public String getSku() {
      return sku;
   }

   public String getLabel() {
      return label;
   }

   public Integer getPriceMultiplyCount() {
      return priceMultiplyCount;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public Integer getPrice() {
      return price;
   }

   public String getRusSize() {
      return rusSize;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ProductData that = (ProductData) o;
      return Objects.equals(name, that.name) &&
              Objects.equals(brandName, that.brandName) &&
              Objects.equals(sku, that.sku) &&
              Objects.equals(label, that.label) &&
              Objects.equals(price, that.price);
   }

   @Override
   public int hashCode() {

      return Objects.hash(name, brandName, sku, label, price);
   }

   @Override
   public String toString() {
      return "ProductData{" +
              "name='" + name + '\'' +
              ", brandName='" + brandName + '\'' +
              ", sku='" + sku + '\'' +
              ", label='" + label + '\'' +
              ", priceMultiplyCount=" + priceMultiplyCount +
              ", quantity=" + quantity +
              ", price=" + price +
              ", rusSize='" + rusSize + '\'' +
              '}';
   }
}
