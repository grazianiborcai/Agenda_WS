package br.com.mind5.business.company.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CompInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCompany;
	public long codSnapshot;
	public String cnpj;
	public String inscrMun;
	public String inscrEst;
	public String razaoSocial;	
	public String name;
	public String nameSearch;
	public String codEntityCateg;
	public String codCountryLegal;
	public String txtCountryLegal;
	public String email;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;	
	public String username;
	
	
	public CompInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCompany = DefaultValue.number();
		codSnapshot = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static CompInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CompInfo.class);
	}
	
	
	
	public static List<CompInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CompInfo.class);
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
		
		if (name != null)
			result = result * 31 + name.hashCode();
		
		if (codEntityCateg != null)
			result = result * 31 + codEntityCateg.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CompInfo))
			return false;
		
		
		CompInfo obj = (CompInfo) o;		
		return (codOwner 	== obj.codOwner 							&& 
				codCompany 	== obj.codCompany							&&
				super.isStringEqual(cnpj, obj.cnpj)						&&
				super.isStringEqual(name, obj.name)						&&
				super.isStringEqual(codEntityCateg, obj.codEntityCateg)		);
	}
}
