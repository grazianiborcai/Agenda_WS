package br.com.mind5.business.cartItemSearch.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CartemarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codUser;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public String username;
	
	
	public CartemarchInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
	}
	
	
	
	public static CartemarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartemarchInfo.class);
	}
	
	
	
	public static List<CartemarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartemarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codUser 	  ^ (codUser 	 >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CartemarchInfo))
			return false;
		
		
		CartemarchInfo obj = (CartemarchInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codUser     == obj.codUser			&&
				codStore    == obj.codStore			&&
				codMat    	== obj.codMat			&&
				codEmployee == obj.codEmployee		&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}
}
