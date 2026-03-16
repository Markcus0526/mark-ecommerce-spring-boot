package com.markcus.spring.business.orderItem.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private Integer orderId;
	
//	public OrderItemId(Integer productId, Integer orderId) {
//		this.productId = productId;
//		this.orderId = orderId;
//	}
//
//	public Integer getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}
//
//	public Integer getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
}











