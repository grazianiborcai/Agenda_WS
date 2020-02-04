package br.com.mind5.business.cartReserveConflict.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CartercoInfo extends InfoRecord implements Cloneable {	
	public long codOwner;	
	public long codUser;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public CartercoInfo() {
		super(CartercoInfo.class);
		
		codOwner = DefaultValue.number();	
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
	}
	
	
	
	public static CartercoInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartercoInfo.class);
	}
	
	
	
	public static List<CartercoInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartercoInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codUser     ^ (codUser     >>> 32));
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
		
		
		if (!(o instanceof CartercoInfo))
			return false;
		
		
		CartercoInfo obj = (CartercoInfo) o;		
		return (codOwner    == obj.codOwner    			&&
				codUser     == obj.codUser    			&&
				codStore 	== obj.codStore 			&&
				codMat  	== obj.codMat	   			&&
				codEmployee == obj.codEmployee	   		&&
				isDateEqual(date, obj.date)	   			&&
				isTimeEqual(beginTime, obj.beginTime)	&&
				isTimeEqual(endTime, obj.endTime));
	}
}
