package br.com.mind5.masterData.petType.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PetypeInfo extends InfoRecord implements Cloneable {
	public int petype;
	public String txtPetype;
	
	
	public PetypeInfo() {
		super();
		
		petype = DefaultValue.number();
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
		return petype;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PetypeInfo))
			return false;
		
		
		PetypeInfo obj = (PetypeInfo) o;
		return petype == obj.petype;
	}
}
