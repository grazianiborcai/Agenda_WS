package br.com.gda.payment.ownerPartner.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OwnparInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codPayPartner;
	public boolean isDefault;
	public String codCountry;
	public String txtCountry;
	public String txtPayPartner;
	public String description;
	public String codLanguage;
	public String username;
	
	
	
	public OwnparInfo() {
		super(OwnparInfo.class);
		
		codOwner = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		isDefault = DefaultValue.boole();
	}
	
	
	
	public static OwnparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnparInfo.class);
	}
	
	
	
	public static List<OwnparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnparInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner      ^ (codOwner      >>> 32));
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OwnparInfo))
			return false;
		
		
		OwnparInfo obj = (OwnparInfo) o;		
		return (codOwner 	  == obj.codOwner && 
				codPayPartner == obj.codPayPartner);
	}
}
