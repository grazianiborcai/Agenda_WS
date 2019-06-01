package br.com.gda.business.order.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrderInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codOrder;	
	public String codOrderExt;	
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public double itemTotal;
	public double feeService;
	public double grandTotal;	
	public String codCurr;
	public String txtCurr;
	public String codOrderStatus;
	public String txtOrderStatus;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public String username;
	public List<CartemInfo> cartems;
	
	
	
	public OrderInfo() {
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		itemTotal = DefaultValue.number();
		feeService = 0;
		grandTotal = DefaultValue.number();
		codLanguage = DefaultValue.language();
		cartems = DefaultValue.list();
	}
	
	
	
	public static OrderInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderInfo.class);
	}
	
	
	
	public static List<OrderInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrderInfo deepCopy = (OrderInfo) super.clone();
		
		if (lastChanged != null)
			deepCopy.lastChanged = lastChanged;
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codOrder ^ (codOrder >>> 32));
		result = result * 31 + (int) (codUser  ^ (codUser  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrderInfo))
			return false;
		
		
		OrderInfo obj = (OrderInfo) o;		
		return (codOwner    == obj.codOwner && 
				codOrder 	== obj.codOrder &&
				codUser     == obj.codUser		);
	}
}
