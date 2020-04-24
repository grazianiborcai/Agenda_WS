package br.com.mind5.masterData.dayParting.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class DaypartInfo extends InfoRecord implements Cloneable {
	public int codDaypart;
	public String txtDaypart;
	
	
	public DaypartInfo() {
		super();
		
		codDaypart = DefaultValue.number();	
	}
	
	
	
	public static DaypartInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DaypartInfo.class);
	}
	
	
	
	public static List<DaypartInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DaypartInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codDaypart;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DaypartInfo))
			return false;
		
		
		DaypartInfo obj = (DaypartInfo) o;		
		return (codDaypart == obj.codDaypart);
	}
}
