package br.com.mind5.business.employeeWorkTimeSnapshot.info;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public class EmpwotmapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;
	public String txtTimezone;
	public long codSnapshot;
	public String recordMode;	
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public EmpwotmapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static EmpwotmapInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, EmpwotmapInfo.class);
	}
	
	
	
	public static List<EmpwotmapInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpwotmapInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return super.clone(); 
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codSnapshot    ^ (codSnapshot    >>> 32));
		result = result * 31 + (int) (codOwner       ^ (codOwner       >>> 32));
		result = result * 31 + (int) (codStore       ^ (codStore       >>> 32));
		result = result * 31 + (int) (codEmployee    ^ (codEmployee    >>> 32));
		result = result * 31 + codWeekday;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpwotmapInfo))
			return false;
		
		
		EmpwotmapInfo obj = (EmpwotmapInfo) o;		
		return (codSnapshot == obj.codSnapshot 	&& 
				codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codEmployee == obj.codEmployee 	&&
				codWeekday 	== obj.codWeekday);
	}
}