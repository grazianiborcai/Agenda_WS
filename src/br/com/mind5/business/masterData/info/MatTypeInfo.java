package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatTypeInfo extends InfoRecord implements Cloneable {
	public int codType;
	public String txtType;
	
	
	public MatTypeInfo() {
		super(MatTypeInfo.class);
		
		codType = DefaultValue.number();
	}
	
	
	
	public static MatTypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatTypeInfo.class);
	}
	
	
	
	public static List<MatTypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatTypeInfo.class);
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
		
		
		if (!(o instanceof MatTypeInfo))
			return false;
		
		
		MatTypeInfo obj = (MatTypeInfo) o;		
		return (codType == obj.codType);
	}
}
