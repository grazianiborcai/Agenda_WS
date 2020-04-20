package br.com.mind5.masterData.materialType.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatypeInfo extends InfoRecord implements Cloneable {
	public int codType;
	public String txtType;
	
	
	public MatypeInfo() {
		super(MatypeInfo.class);
		
		codType = DefaultValue.number();
	}
	
	
	
	public static MatypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatypeInfo.class);
	}
	
	
	
	public static List<MatypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatypeInfo.class);
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
		
		
		if (!(o instanceof MatypeInfo))
			return false;
		
		
		MatypeInfo obj = (MatypeInfo) o;		
		return (codType == obj.codType);
	}
}
