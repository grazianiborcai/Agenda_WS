package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class OwnerInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String name;
	public String codLanguage;
	public String recordMode;
	//TODO: legal_country - dados sensiveis precisam atender legislacao do pais
	
	
	public OwnerInfo() {
		this.codOwner = DefaultValue.number();
		this.codLanguage = DefaultValue.language();
		this.recordMode = RecordMode.RECORD_OK;	
	}
	
	
	
	public static OwnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnerInfo.class);
	}
	
	
	
	public static List<OwnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnerInfo.class);
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
		
		
		if (!(o instanceof OwnerInfo))
			return false;
		
		
		OwnerInfo obj = (OwnerInfo) o;		
		return (codOwner == obj.codOwner);
	}	
}
