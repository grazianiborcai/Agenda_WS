package br.com.mind5.masterData.petWeightSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PeteightarchInfo extends InfoRecord implements Cloneable {
	public int codPeteight;
	public String txtPeteightKg;
	
	
	public PeteightarchInfo() {
		super();
		
		codPeteight = DefaultValue.number();
	}
	
	
	
	public static PeteightarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PeteightarchInfo.class);
	}
	
	
	
	public static List<PeteightarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PeteightarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {		
		return codPeteight;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PeteightarchInfo))
			return false;
		
		
		PeteightarchInfo obj = (PeteightarchInfo) o;
		return codPeteight == obj.codPeteight;
	}
}
