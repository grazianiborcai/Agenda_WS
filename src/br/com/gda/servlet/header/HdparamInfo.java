package br.com.gda.servlet.header;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class HdparamInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	
	
	public HdparamInfo() {
		codOwner = DefaultValue.number();
	}
	
	
	
	public static HdparamInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, HdparamInfo.class);
	}
	
	
	
	public static List<HdparamInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, HdparamInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof HdparamInfo))
			return false;
		
		
		HdparamInfo obj = (HdparamInfo) o;		
		return (codOwner == obj.codOwner);
	}	
}
