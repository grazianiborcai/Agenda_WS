package br.com.mind5.masterData.moonPhaseSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MoonasarchInfo extends InfoRecord implements Cloneable {
	public int codMoonPhase;
	public String txtMoonPhase;
	
	
	public MoonasarchInfo() {
		super(MoonasarchInfo.class);
		
		codMoonPhase = DefaultValue.number();	
	}
	
	
	
	public static MoonasarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MoonasarchInfo.class);
	}
	
	
	
	public static List<MoonasarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MoonasarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codMoonPhase;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MoonasarchInfo))
			return false;
		
		
		MoonasarchInfo obj = (MoonasarchInfo) o;		
		return (codMoonPhase == obj.codMoonPhase);
	}
}
