package br.com.mind5.business.storeProspect.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoprosInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStoreProspect;		
	public String prospectName;
	public String prospectPhone;
	public String prospectEmail;
	public String codProspectStatus;
	public String txtProspectStatus;
	public String notes;
	public String password;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public String username;
	public String recordMode;
	
	
	public StoprosInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStoreProspect = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StoprosInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoprosInfo.class);
	}
	
	
	
	public static List<StoprosInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoprosInfo.class);
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
		
		
		if (!(o instanceof StoprosInfo))
			return false;
		
		
		StoprosInfo obj = (StoprosInfo) o;		
		return (codOwner 		 == obj.codOwner && 
				codStoreProspect == obj.codStoreProspect);
	}
}
