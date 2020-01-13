package br.com.mind5.business.order.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrderInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codOrder;	
	public long codSnapshot;
	public String codOrderExt;	
	public long codCustomer;
	public long codUser;
	public long codAddressShip;
	public long codAddressInvoice;
	public long codPhoneShip;
	public long codPhoneInvoice;
	public double itemTotal;
	public double feeService;
	public double grandTotal;	
	public String codCurr;
	public String txtCurr;
	public char codFeeCateg;
	public String txtFeeCateg;
	public String codOrderStatus;
	public String txtOrderStatus;
	public long codPayOrder;
	public int codPayPartner;
	public String statusOrderPartner;
	public String statusPaymentPartner;
	public LocalDateTime lastChanged;
	public LocalDateTime createdOn;
	public long lastChangedBy;
	public long createdBy;
	public String username;
	public List<OrderemInfo> orderms;
	
	
	public OrderInfo() {
		super(OrderInfo.class);
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();			
		codSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codAddressShip = DefaultValue.number();
		codAddressInvoice = DefaultValue.number();
		codPhoneShip = DefaultValue.number();
		codPhoneInvoice = DefaultValue.number();
		itemTotal = DefaultValue.number();
		feeService = 0;
		codFeeCateg = DefaultValue.character();
		grandTotal = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
		orderms = DefaultValue.list();
	}
	
	
	
	public static OrderInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderInfo.class);
	}
	
	
	
	public static List<OrderInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrderInfo deepCopy = (OrderInfo) super.clone();
		
		deepCopy.orderms = cloneOrderems(orderms);		
		return deepCopy;
	}
	
	
	
	private List<OrderemInfo> cloneOrderems(List<OrderemInfo> recordInfos) throws CloneNotSupportedException {
		List<OrderemInfo> results = new ArrayList<>();
		
		if (recordInfos == null)
			return null;
		
		for (OrderemInfo eachRecord : recordInfos) {
			OrderemInfo clonedRecord = (OrderemInfo) eachRecord.clone();
			results.add(clonedRecord);
		}
		
		
		return results;
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
