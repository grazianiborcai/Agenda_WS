package br.com.mind5.business.materialSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatsnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codStore;
	public long codMat;
	public String txtMat;
	public String description;
	public int codType;
	public String txtType;
	public int codMatCateg;
	public String txtMatCateg;
	public int priceUnit;
	public String codUnit;
	public String txtUnit;
	public int codGroup;
	public String txtGroup; 
	public int codSubgroup;
	public String txtSubgroup;
	public int codBusiness;
	public String txtBusiness; 
	public boolean isLocked;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public MatsnapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codMatCateg = DefaultValue.number();
		priceUnit = DefaultValue.number();
		codGroup = DefaultValue.number();		
		codSubgroup = DefaultValue.number();
		codBusiness = DefaultValue.number();
		isLocked = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static MatsnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatsnapInfo.class);
	}
	
	
	
	public static List<MatsnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatsnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  	^ (codOwner		>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		result = result * 31 + (int) (codMat 		^ (codMat 		>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatsnapInfo))
			return false;
		
		
		MatsnapInfo obj = (MatsnapInfo) o;		
		return (codOwner 	== obj.codOwner 	&&
				codSnapshot == obj.codSnapshot 	&&
				codMat 		== obj.codMat		);
	}
}
