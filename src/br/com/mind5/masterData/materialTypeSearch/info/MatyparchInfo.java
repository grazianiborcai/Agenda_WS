package br.com.mind5.masterData.materialTypeSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatyparchInfo extends InfoRecord implements Cloneable {
	public int codType;
	public String txtType;
	
	
	public MatyparchInfo() {
		super();
		
		codType = DefaultValue.number();
	}
	
	
	
	public static MatyparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatyparchInfo.class);
	}
	
	
	
	public static List<MatyparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatyparchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codType;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatyparchInfo))
			return false;
		
		
		MatyparchInfo obj = (MatyparchInfo) o;		
		return (codType == obj.codType);
	}
}
