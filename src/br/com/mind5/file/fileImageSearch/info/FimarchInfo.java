package br.com.mind5.file.fileImageSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FimarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codFileImg;
	public long codPerson;
	public long codEmployee;
	public long codCustomer;
	public long codUser;
	public long codMat;
	public long codStore;
	public long codOwnerRef;
	public int codGroup;
	public String recordMode;
	public String username;
	
	
	public FimarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codFileImg = DefaultValue.number();		
		codPerson = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();		
		codOwnerRef = DefaultValue.number();
		codGroup = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FimarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimarchInfo.class);
	}
	
	
	
	public static List<FimarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner   ^ (codOwner   >>> 32));
		result = result * 31 + (int) (codFileImg ^ (codFileImg >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimarchInfo))
			return false;
		
		
		FimarchInfo obj = (FimarchInfo) o;		
		return (codOwner    == obj.codOwner   && 
				codFileImg 	== obj.codFileImg		);
	}	
}
