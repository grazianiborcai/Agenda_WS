package br.com.mind5.masterData.petWeight.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PeteightInfo extends InfoRecord implements Cloneable {
	public int codPeteight;
	public String txtPeteightKg;
	
	
	public PeteightInfo() {
		super();
		
		codPeteight = DefaultValue.number();
	}
	
	
	
	public static PeteightInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PeteightInfo.class);
	}
	
	
	
	public static List<PeteightInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PeteightInfo.class);
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
		
		
		if (!(o instanceof PeteightInfo))
			return false;
		
		
		PeteightInfo obj = (PeteightInfo) o;
		return codPeteight == obj.codPeteight;
	}
}
