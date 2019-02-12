package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class RolurInfo  extends InfoRecord implements Cloneable {
	public String codRole;
	public String codUri;
	
	
	public static RolurInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RolurInfo.class);
	}
	
	
	
	public static List<RolurInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RolurInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codRole != null)
			result = result * 31 + codRole.hashCode();
		
		if (codUri != null)
			result = result * 31 + codUri.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RolurInfo))
			return false;
		
		
		RolurInfo obj = (RolurInfo) o;		
		return (super.isStringEqual(codRole, obj.codRole) 	&&
				super.isStringEqual(codUri, obj.codUri)			);
	}
}
