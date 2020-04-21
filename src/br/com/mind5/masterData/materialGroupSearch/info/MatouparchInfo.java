package br.com.mind5.masterData.materialGroupSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public class MatouparchInfo extends InfoRecord implements Cloneable {
	public int codGroup;
	public String txtGroup;
	public int codBusiness;
	public String txtBusiness; 
	
	
	public MatouparchInfo() {
		super();
		
		codGroup = DefaultValue.number();
		codBusiness = DefaultValue.number();
	}
	
	
	
	public static MatouparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatouparchInfo.class);
	}
	
	
	
	public static List<MatouparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatouparchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codGroup;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatouparchInfo))
			return false;
		
		
		MatouparchInfo obj = (MatouparchInfo) o;		
		return (codGroup == obj.codGroup);
	}
}
