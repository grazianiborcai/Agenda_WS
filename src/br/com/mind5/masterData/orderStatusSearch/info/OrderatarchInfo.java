package br.com.mind5.masterData.orderStatusSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class OrderatarchInfo extends InfoRecord implements Cloneable {
	public String codOrderStatus;
	public String txtOrderStatus;
	
	
	public OrderatarchInfo() {
		super();
	}
	
	
	
	public static OrderatarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderatarchInfo.class);
	}
	
	
	
	public static List<OrderatarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderatarchInfo.class);
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
		
		
		if (!(o instanceof OrderatarchInfo))
			return false;
		
		
		OrderatarchInfo obj = (OrderatarchInfo) o;		
		return (isStringEqual(codOrderStatus, obj.codOrderStatus));
	}
}
