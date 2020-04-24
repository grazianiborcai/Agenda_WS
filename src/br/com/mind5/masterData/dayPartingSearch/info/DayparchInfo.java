package br.com.mind5.masterData.dayPartingSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class DayparchInfo extends InfoRecord implements Cloneable {
	public int codDaypart;
	public String txtDaypart;
	
	
	public DayparchInfo() {
		super();
		
		codDaypart = DefaultValue.number();	
	}
	
	
	
	public static DayparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DayparchInfo.class);
	}
	
	
	
	public static List<DayparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DayparchInfo.class);
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
		
		
		if (!(o instanceof DayparchInfo))
			return false;
		
		
		DayparchInfo obj = (DayparchInfo) o;		
		return (codDaypart == obj.codDaypart);
	}
}
