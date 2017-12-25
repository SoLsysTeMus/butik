package model;

import java.util.Objects;

public class ProductData {

   private final String name;
   private final String brandName;
   private final String sku;
   private final String label;
   private final Integer priceMultiplyCount;

   public ProductData(String name, String brandName, String sku, String label, Integer priceMultiplyCount) {

      this.name = name;
      this.brandName = brandName;
      this.sku = sku;
      this.label = label;
      this.priceMultiplyCount = priceMultiplyCount;
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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ProductData that = (ProductData) o;
      return Objects.equals(name, that.name) &&
              Objects.equals(brandName, that.brandName) &&
              Objects.equals(sku, that.sku) &&
              Objects.equals(label, that.label) &&
              Objects.equals(priceMultiplyCount, that.priceMultiplyCount);
   }

   @Override
   public int hashCode() {

      return Objects.hash(name, brandName, sku, label, priceMultiplyCount);
   }

   @Override
   public String toString() {
      return "ProductData{" +
              "name='" + name + '\'' +
              ", brandName='" + brandName + '\'' +
              ", sku='" + sku + '\'' +
              ", label='" + label + '\'' +
              ", priceMultiplyCount=" + priceMultiplyCount +
              '}';
   }
}
