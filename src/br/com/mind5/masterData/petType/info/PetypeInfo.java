package br.com.mind5.masterData.petType.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PetypeInfo extends InfoRecord implements Cloneable {
	public int codPetype;
	public String txtPetype;
	
	
	public PetypeInfo() {
		super();
		
		codPetype = DefaultValue.number();
	}
	
	
	
	public static PetypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PetypeInfo.class);
	}
	
	
	
	public static List<PetypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PetypeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {		
		return codPetype;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PetypeInfo))
			return false;
		
		
		PetypeInfo obj = (PetypeInfo) o;
		return codPetype == obj.codPetype;
	}
}
