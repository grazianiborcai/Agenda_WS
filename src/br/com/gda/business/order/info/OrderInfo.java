package br.com.gda.business.order.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrderInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codOrder;
	public int itemNumber;
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
	public String matUnit;
	public double matPrice;
	public String matCodCurr;
	public int matCodType;
	public int matCodCategory;
	public int matPriceUnit;
	public int matCodGroup;
	public LocalTime matBeginTime;
	public LocalTime matEndTime;
	public LocalDate matDate;
	public String storeCnpj;
	public String storeInscMunicipal;
	public String storeInscEstadual;
	public String storeName;
	public String storeCountry;
	public String storeStateProvince;
	public String storeCodCurr;
	public String storeCodTimezone;
	public long codEmployee;
	public String empCpf;
	
	
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
		lastChanged = DefaultValue.dateTimeNow();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static OrderInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderInfo.class);
	}
	
	
	
	public static List<OrderInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderInfo.class);
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
