package br.com.mind5.business.companySearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class ComparchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCompany;
	public long codSnapshot;
	public String cnpj;
	public String codEntityCateg;
	public String email;
	public String recordMode;
	public String username;
	
	
	public ComparchInfo() {
		super(ComparchInfo.class);
		
		codOwner = DefaultValue.number();
		codCompany = DefaultValue.number();
		codSnapshot = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static ComparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, ComparchInfo.class);
	}
	
	
	
	public static List<ComparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, ComparchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codCompany ^ (codCompany >>> 32));
		
		if (cnpj != null)
			result = result * 31 + cnpj.hashCode();
		
		if (codEntityCateg != null)
			result = result * 31 + codEntityCateg.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof ComparchInfo))
			return false;
		
		
		ComparchInfo obj = (ComparchInfo) o;		
		return (codOwner 	== obj.codOwner 							&& 
				codCompany 	== obj.codCompany							&&
				super.isStringEqual(cnpj, obj.cnpj)						&&
				super.isStringEqual(codEntityCateg, obj.codEntityCateg)		);
	}
}
