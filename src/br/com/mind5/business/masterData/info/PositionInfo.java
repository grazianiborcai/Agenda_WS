package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PositionInfo extends InfoRecord implements Cloneable {
	public int codPosition;
	public String txtPosition;
	
	
	public PositionInfo() {
		super(PositionInfo.class);
		
		codPosition = DefaultValue.number();
	}
	
	
	
	public static PositionInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PositionInfo.class);
	}
	
	
	
	public static List<PositionInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PositionInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) codPosition;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PositionInfo))
			return false;
		
		
		PositionInfo obj = (PositionInfo) o;		
		return (codPosition == obj.codPosition);
	}
}
