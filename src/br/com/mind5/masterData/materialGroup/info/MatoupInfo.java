package br.com.mind5.masterData.materialGroup.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public class MatoupInfo extends InfoRecord implements Cloneable {
	public int codGroup;
	public String txtGroup;
	public int codBusiness;
	public String txtBusiness; 
	
	
	public MatoupInfo() {
		super();
		
		codGroup = DefaultValue.number();
		codBusiness = DefaultValue.number();
	}
	
	
	
	public static MatoupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatoupInfo.class);
	}
	
	
	
	public static List<MatoupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatoupInfo.class);
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
		
		
		if (!(o instanceof MatoupInfo))
			return false;
		
		
		MatoupInfo obj = (MatoupInfo) o;		
		return (codGroup == obj.codGroup);
	}
}
