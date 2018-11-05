package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrderStatusInfo extends InfoRecord implements Cloneable {
	public String codOrderStatus;
	public String txtOrderStatus;
	public String codLanguage;
	
	
	public OrderStatusInfo() {
		this.codLanguage = DefaultValue.language();
	}
	
	
	
	public static OrderStatusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderStatusInfo.class);
	}
	
	
	
	public static List<OrderStatusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderStatusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (codOrderStatus == null)
			return 0;
		
		return codOrderStatus.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrderStatusInfo))
			return false;
		
		
		OrderStatusInfo obj = (OrderStatusInfo) o;		
		return (isStringEqual(codOrderStatus, obj.codOrderStatus));
	}
}
