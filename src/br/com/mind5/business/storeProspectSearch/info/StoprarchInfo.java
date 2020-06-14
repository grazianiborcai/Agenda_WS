package br.com.mind5.business.storeProspectSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoprarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStoreProspect;		
	public String prospectName;
	public String prospectPhone;
	public String prospectEmail;
	public String codProspectStatus;
	public String recordMode;
	public String username;
	
	
	public StoprarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStoreProspect = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StoprarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoprarchInfo.class);
	}
	
	
	
	public static List<StoprarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoprarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 			^ (codOwner 		>>> 32));
		result = result * 31 + (int) (codStoreProspect 	^ (codStoreProspect >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoprarchInfo))
			return false;
		
		
		StoprarchInfo obj = (StoprarchInfo) o;		
		return (codOwner 		 == obj.codOwner && 
				codStoreProspect == obj.codStoreProspect);
	}
}
