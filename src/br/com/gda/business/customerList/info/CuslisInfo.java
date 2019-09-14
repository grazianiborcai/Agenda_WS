package br.com.gda.business.customerList.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CuslisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codSnapshot;
	public long codPerson;
	public long codUser;
	public String codEntityCateg;
	public char codUserCategory;
	public String codAuthGroup;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public PersolisInfo personData;
	public String username;
	public String codLanguage;
	
	
	public CuslisInfo() {
		super(CuslisInfo.class);
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
		personData = DefaultValue.object();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static CuslisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CuslisInfo.class);
	}
	
	
	
	public static List<CuslisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CuslisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CuslisInfo deepCopy = (CuslisInfo) super.clone();		
		deepCopy.personData = clonePersolis(deepCopy.personData);		
		return deepCopy;
	}
	
	
	
	private PersolisInfo clonePersolis(PersolisInfo recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		return (PersolisInfo) recordInfos.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CuslisInfo))
			return false;
		
		
		CuslisInfo obj = (CuslisInfo) o;		
		return (codOwner    == obj.codOwner && 
				codCustomer == obj.codCustomer);
	}
}
