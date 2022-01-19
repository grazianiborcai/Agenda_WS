package br.com.mind5.masterData.petTypeSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PetyparchInfo extends InfoRecord implements Cloneable {
	public int codPetype;
	public String txtPetype;
	
	
	public PetyparchInfo() {
		super();
		
		codPetype = DefaultValue.number();
	}
	
	
	
	public static PetyparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PetyparchInfo.class);
	}
	
	
	
	public static List<PetyparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PetyparchInfo.class);
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
		
		
		if (!(o instanceof PetyparchInfo))
			return false;
		
		
		PetyparchInfo obj = (PetyparchInfo) o;
		return codPetype == obj.codPetype;
	}
}
