package com.solvd.laba.homesellingcompany.entities.base;

import com.solvd.laba.homesellingcompany.entities.interfaces.PricedProperty;

import java.util.List;

public abstract class Building {
   public int price;
   public double squareMeters;
   public String location;
   public boolean isNew;

   public static <T extends PricedProperty> T bestBuilding(List<T> properties) {
      T bestPricedProperty = null;
      for (T property : properties) {
         if (bestPricedProperty == null || property.getPrice() < bestPricedProperty.getPrice()) {
            bestPricedProperty = property;
         }
      }
      return bestPricedProperty;
   }
}

