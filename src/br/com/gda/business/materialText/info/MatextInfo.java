package br.com.gda.business.materialText.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MatextInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codMat;
	public String txtMat;
	public String description;
	public boolean isDefault;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public MatextInfo() {
		super(MatextInfo.class);
		
		codOwner = DefaultValue.number();
		codMat = DefaultValue.number();
		isDefault = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static MatextInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatextInfo.class);
	}
	
	
	
	public static List<MatextInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatextInfo.class);
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
		
		
		if (!(o instanceof MatextInfo))
			return false;
		
		
		MatextInfo obj = (MatextInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codMat   == obj.codMat		&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
