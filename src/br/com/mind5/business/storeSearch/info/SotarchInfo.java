package br.com.mind5.business.storeSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SotarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codCompany;
	public long codUser;
	public String nameSearch;
	public String username;
	public String recordMode;
	
	
	public SotarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codCompany = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static SotarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SotarchInfo.class);
	}
	
	
	
	public static List<SotarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SotarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SotarchInfo))
			return false;
		
		
		SotarchInfo obj = (SotarchInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore);
	}
}
