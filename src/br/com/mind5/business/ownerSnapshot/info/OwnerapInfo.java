package br.com.mind5.business.ownerSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OwnerapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPerson;
	public long codPersonSnapshot;
	public long codCompany;
	public long codCompanySnapshot;
	public long codUser;
	public long codUserSnapshot;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String recordMode;
	public String username;
	
	
	
	public OwnerapInfo() {
		super(OwnerapInfo.class);
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		codCompany = DefaultValue.number();
		codCompanySnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static OwnerapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnerapInfo.class);
	}
	
	
	
	public static List<OwnerapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnerapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner >>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OwnerapInfo))
			return false;
		
		
		OwnerapInfo obj = (OwnerapInfo) o;		
		return (codOwner 	== obj.codOwner &&
				codSnapshot == obj.codSnapshot);
	}	
}
