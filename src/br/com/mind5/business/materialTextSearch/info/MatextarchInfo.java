package br.com.mind5.business.materialTextSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatextarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codMat;
	public String recordMode;
	public String username;
	
	
	public MatextarchInfo() {
		super(MatextarchInfo.class);
		
		codOwner = DefaultValue.number();
		codMat = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static MatextarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatextarchInfo.class);
	}
	
	
	
	public static List<MatextarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatextarchInfo.class);
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
		
		
		if (!(o instanceof MatextarchInfo))
			return false;
		
		
		MatextarchInfo obj = (MatextarchInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codMat   == obj.codMat		&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
