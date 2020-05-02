package br.com.mind5.masterData.orderStatus.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class OrderatusInfo extends InfoRecord implements Cloneable {
	public String codOrderStatus;
	public String txtOrderStatus;
	
	
	public OrderatusInfo() {
		super();
	}
	
	
	
	public static OrderatusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderatusInfo.class);
	}
	
	
	
	public static List<OrderatusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderatusInfo.class);
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
		
		
		if (!(o instanceof OrderatusInfo))
			return false;
		
		
		OrderatusInfo obj = (OrderatusInfo) o;		
		return (isStringEqual(codOrderStatus, obj.codOrderStatus));
	}
}
