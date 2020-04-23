package br.com.mind5.business.orderReserve.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrderveInfo extends InfoRecord implements Cloneable {	
	public long codOwner;
	public long codOrder;
	public long codUser;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;	
	public String codOrderStatus;
	public String username;
	
	
	public OrderveInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();	
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
	}
	
	
	
	public static OrderveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderveInfo.class);
	}
	
	
	
	public static List<OrderveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderveInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrderveInfo deepCopy = (OrderveInfo) super.clone();
		
		deepCopy.date = date;
		deepCopy.beginTime = beginTime;
		deepCopy.endTime = endTime;
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat  	  ^ (codMat  	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		if (date != null) 
			result = result * 31 + date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + beginTime.hashCode();
		
		if (endTime != null)
			result = result * 31 + endTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrderveInfo))
			return false;
		
		
		OrderveInfo obj = (OrderveInfo) o;		
		return (codOwner    == obj.codOwner    			&&
				codStore 	== obj.codStore 			&&
				codMat  	== obj.codMat	   			&&
				codEmployee == obj.codEmployee	   		&&
				isDateEqual(date, obj.date)	   			&&
				isTimeEqual(beginTime, obj.beginTime)	&&
				isTimeEqual(endTime, obj.endTime));
	}
}
