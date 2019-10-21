package br.com.mind5.business.companyList.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class ComplisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCompany;
	public long codSnapshot;
	public String razaoSocial;	
	public String name;
	public String email;
	public String recordMode;
	public String username;
	
	
	public ComplisInfo() {
		super(ComplisInfo.class);
		
		codOwner = DefaultValue.number();
		codCompany = DefaultValue.number();
		codSnapshot = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static ComplisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, ComplisInfo.class);
	}
	
	
	
	public static List<ComplisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, ComplisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codCompany ^ (codCompany >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof ComplisInfo))
			return false;
		
		
		ComplisInfo obj = (ComplisInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codCompany 	== obj.codCompany);
	}
}
