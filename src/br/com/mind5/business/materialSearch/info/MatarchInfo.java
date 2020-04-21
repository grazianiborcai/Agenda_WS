package br.com.mind5.business.materialSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codMat;
	public String txtMat;
	public String txtMatSearch;
	public int codType;
	public int codMatCateg;
	public int codGroup;
	public int codBusiness;
	public boolean isLocked;
	public String recordMode;
	public String username;
	
	
	public MatarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codMatCateg = DefaultValue.number();
		codGroup = DefaultValue.number();		
		codBusiness = DefaultValue.number();
		isLocked = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static MatarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatarchInfo.class);
	}
	
	
	
	public static List<MatarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();		
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codMat 	^ (codMat 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatarchInfo))
			return false;
		
		
		MatarchInfo obj = (MatarchInfo) o;		
		return (codOwner == obj.codOwner && 
				codMat   == obj.codMat);
	}
}
