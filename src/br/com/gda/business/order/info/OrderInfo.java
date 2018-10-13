package br.com.gda.business.order.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrderInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codOrder;
	public int itemNumber;
	public char codItemCateg;
	public String codOrderExt;
	public long codCustomer;	
	public String codOrderStatus;
	public LocalDateTime lastChanged;
	public String cusCpf;
	public String cusEmail;
	public String cusName;
	public String codLanguage;
	public String cusCodCountry;
	public String cusCodState;
	public long codStore;
	public long codMat;
	public String matTxt;
	public String matUnit;
	public double matPrice;
	public int matQuantity;
	public String matCodCurr;
	public int matCodType;
	public int matCodCategory;
	public int matPriceUnit;
	public int matCodGroup;
	public LocalTime matBeginTime;
	public LocalTime matEndTime;
	public LocalDate matDate;
	public String storeCnpj;
	public String storeInscrMun;
	public String storeInscrEst;
	public String storeName;
	public String storeCountry;
	public String storeStateProvince;
	public String storeCodCurr;
	public String storeCodTimezone;
	public long codEmployee;
	public String empCpf;
	public String empName;
	
	
	public OrderInfo() {
		codOwner = DefaultValue.number();
		codOrder = DefaultValue.number();
		itemNumber = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();
		matPrice = DefaultValue.number();
		matCodType = DefaultValue.number();
		matCodCategory = DefaultValue.number();
		matCodGroup = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codLanguage = DefaultValue.language();
		codItemCateg = DefaultValue.character();
		
		computeLChanged();
	}
	
	
	
	private void computeLChanged() {
		OrderSetterLChanged attrSetter = new OrderSetterLChanged();		
		attrSetter.setAttr(this);
	}
	
	
	
	public static OrderInfo copyFrom(Object sourceObj) {
		if (isCart(sourceObj))
			return copyFromCart(sourceObj);
		
		return copyFrom(sourceObj, OrderInfo.class);
	}
	
	
	
	public static List<OrderInfo> copyFrom(List<?> sourceObjs) {
		if (isCart(sourceObjs))
			return copyFromCart(sourceObjs);
		
		return copyFrom(sourceObjs, OrderInfo.class);
	}
	
	
	
	private static boolean isCart(List<?> sourceObjs) {
		if (sourceObjs == null || sourceObjs.isEmpty())
			return false;
		
		return isCart(sourceObjs.get(0));
	}
	
	
	
	private static boolean isCart(Object sourceObj) {
		if (sourceObj == null)
			return false;
		
		if (sourceObj instanceof CartInfo)
			return true;
		
		return false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static List<OrderInfo> copyFromCart(List<?> sourceObjs) {
		return new OrderCopyCart().makeCopy( (List<CartInfo>)sourceObjs);
	}
	
	
	
	private static OrderInfo copyFromCart(Object sourceObj) {
		return new OrderCopyCart().makeCopy( (CartInfo)sourceObj);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner   ^ (codOwner   >>> 32));
		result = result * 31 + (int) (codOrder   ^ (codOrder   >>> 32));
		result = result * 31 + (int) (itemNumber ^ (itemNumber >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrderInfo))
			return false;
		
		
		OrderInfo obj = (OrderInfo) o;		
		return (codOwner   == obj.codOwner && 
				codOrder   == obj.codOrder &&
				itemNumber == obj.itemNumber);
	}	
}
