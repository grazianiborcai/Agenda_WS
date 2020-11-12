package br.com.mind5.business.employeeWorkTimeRange.info;

import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmpworgInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int codWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String username;
	public String recordMode;
	
	
	public EmpworgInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codStore = DefaultValue.number();
		codWeekday = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static EmpworgInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpworgInfo.class);
	}
	
	
	
	public static List<EmpworgInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpworgInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return super.clone();
	} 
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	  ^ (codOwner 	 >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + codWeekday;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpworgInfo))
			return false;
		
		
		EmpworgInfo obj = (EmpworgInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codEmployee == obj.codEmployee 	&&
				codWeekday 	== obj.codWeekday);
	}	
}
