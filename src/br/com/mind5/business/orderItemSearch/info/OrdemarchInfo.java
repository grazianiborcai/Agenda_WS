package br.com.mind5.business.orderItemSearch.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrdemarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codOrder;
	public int codOrderItem;
	public long codStore;
	public long codUser;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String username;
	
	
	public OrdemarchInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();
		codOrderItem = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();		
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
	}
	
	
	
	public static OrdemarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdemarchInfo.class);
	}
	
	
	
	public static List<OrdemarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdemarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    	^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codOrder 	  	^ (codOrder 	 	>>> 32));
		result = result * 31 + (int) (codOrderItem 	^ (codOrderItem 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdemarchInfo))
			return false;
		
		
		OrdemarchInfo obj = (OrdemarchInfo) o;		
		return (codOwner    	== obj.codOwner    	&& 
				codOrder    	== obj.codOrder		&&
				codOrderItem	== obj.codOrderItem		);
	}
}
