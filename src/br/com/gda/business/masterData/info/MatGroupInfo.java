package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public class MatGroupInfo extends InfoRecord implements Cloneable {
	public int codGroup;
	public String txtGroup;
	public int codBusiness;
	public String txtBusiness; 
	
	
	public MatGroupInfo() {
		super(MatGroupInfo.class);
		
		codGroup = DefaultValue.number();
		codBusiness = DefaultValue.number();
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
		
		result = result * 31 + codGroup;
		
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
