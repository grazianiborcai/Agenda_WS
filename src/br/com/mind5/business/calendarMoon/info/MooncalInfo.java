package br.com.mind5.business.calendarMoon.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MooncalInfo extends InfoRecord implements Cloneable {
	public LocalDate moonDate;
	public int codMoonPhase;
	public String txtMoonPhase;
	public LocalTime moonTime;
	public LocalDateTime moonDateTime;
	public String username;
	
	
	public MooncalInfo() {
		super();
		
		moonDate = DefaultValue.object();
		moonTime = DefaultValue.object();
		moonDateTime = DefaultValue.object();
		codMoonPhase = DefaultValue.number();	
	}
	
	
	
	public static MooncalInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MooncalInfo.class);
	}
	
	
	
	public static List<MooncalInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MooncalInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (moonDate != null)		
			result = result * 31 + moonDate.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MooncalInfo))
			return false;
		
		
		MooncalInfo obj = (MooncalInfo) o;		
		return (super.isDateEqual(moonDate, obj.moonDate));
	}
}
