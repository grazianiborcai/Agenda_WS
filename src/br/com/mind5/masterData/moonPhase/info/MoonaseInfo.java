package br.com.mind5.masterData.moonPhase.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MoonaseInfo extends InfoRecord implements Cloneable {
	public int codMoonPhase;
	public String txtMoonPhase;
	
	
	public MoonaseInfo() {
		super(MoonaseInfo.class);
		
		codMoonPhase = DefaultValue.number();	
	}
	
	
	
	public static MoonaseInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MoonaseInfo.class);
	}
	
	
	
	public static List<MoonaseInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MoonaseInfo.class);
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
		
		
		if (!(o instanceof MoonaseInfo))
			return false;
		
		
		MoonaseInfo obj = (MoonaseInfo) o;		
		return (codMoonPhase == obj.codMoonPhase);
	}
}
