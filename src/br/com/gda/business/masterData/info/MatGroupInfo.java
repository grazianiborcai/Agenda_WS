package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public class MatGroupInfo extends RecordInfo implements Cloneable {
	public int codGroup;
	public String txtGroup;
	public int codBusiness;
	public String txtBusiness; 
	public String codLanguage;
	
	
	public MatGroupInfo() {
		this.codGroup = DefaultValue.number();
		this.codBusiness = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static MatGroupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatGroupInfo.class);
	}
	
	
	
	public static List<MatGroupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatGroupInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * codGroup;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatGroupInfo))
			return false;
		
		
		MatGroupInfo obj = (MatGroupInfo) o;		
		return (codGroup == obj.codGroup);
	}
}
