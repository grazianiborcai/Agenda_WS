package br.com.mind5.business.ownerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OwnarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codBusiness;
	public String txtBusiness; 
	public long codCompany;
	public String name;
	public String username;
	public String recordMode;
	
	
	
	public OwnarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codBusiness = DefaultValue.number();
		codCompany = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static OwnarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnarchInfo.class);
	}
	
	
	
	public static List<OwnarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OwnarchInfo))
			return false;
		
		
		OwnarchInfo obj = (OwnarchInfo) o;		
		return (codOwner == obj.codOwner);
	}	
}
