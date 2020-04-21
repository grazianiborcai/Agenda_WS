package br.com.mind5.business.materialTextDefault.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatextaultInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codMat;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public MatextaultInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codMat = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		isDefault = DefaultValue.boole();
	}
	
	
	
	public static MatextaultInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatextaultInfo.class);
	}
	
	
	
	public static List<MatextaultInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatextaultInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codMat 	^ (codMat 	>>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatextaultInfo))
			return false;
		
		
		MatextaultInfo obj = (MatextaultInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codMat   == obj.codMat		&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
