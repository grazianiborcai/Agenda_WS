package br.com.mind5.business.materialTextSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatextsnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codMat;
	public String txtMat;
	public String txtMatSearch;
	public String description;
	public boolean isDefault;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public MatextsnapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codMat = DefaultValue.number();
		isDefault = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static MatextsnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatextsnapInfo.class);
	}
	
	
	
	public static List<MatextsnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatextsnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  	^ (codOwner		>>> 32));
		result = result * 31 + (int) (codMat 		^ (codMat 		>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatextsnapInfo))
			return false;
		
		
		MatextsnapInfo obj = (MatextsnapInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codMat   	== obj.codMat		&&
				codSnapshot == obj.codSnapshot	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
