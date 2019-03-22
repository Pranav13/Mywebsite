package com.epam.order.dto;

import java.util.Arrays;

public final class OrderDto {
    public final String datePlaced;
    public final Shipping shipping;
    public final Item items[];
    public final String userId;

    public OrderDto(String datePlaced, Shipping shipping, Item[] items,String userId){
        this.datePlaced = datePlaced;
        this.shipping = shipping;
        this.items = items;
        this.userId = userId;
    }

    public static final class Shipping {
        public final String name;
        public final String addressLine1;
        public final String addressLine2;
        public final String city;

        public Shipping(String name, String addressLine1, String addressLine2, String city){
            this.name = name;
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
        }

		@Override
		public String toString() {
			return "Shipping [name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
					+ ", city=" + city + "]";
		}
        
    }

    public static final class Item {
        public final Product product;
        public final long quantity;

        public Item(Product product, long quantity){
            this.product = product;
            this.quantity = quantity;
        }

        public static final class Product {
            public final String title;
            public final String imageUrl;
            public final long price;
    
            public Product(String title, String imageUrl, long price){
                this.title = title;
                this.imageUrl = imageUrl;
                this.price = price;
            }

			@Override
			public String toString() {
				return "Product [title=" + title + ", imageUrl=" + imageUrl + ", price=" + price + "]";
			}
        }
    }

	@Override
	public String toString() {
		return "OrderDto [datePlaced=" + datePlaced + ", shipping=" + shipping + ", items=" + Arrays.toString(items)
				+ "]";
	}
    
}
