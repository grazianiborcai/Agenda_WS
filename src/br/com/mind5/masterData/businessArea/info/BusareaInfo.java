package br.com.mind5.masterData.businessArea.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BusareaInfo extends InfoRecord implements Cloneable {
	public int codBusiness;
	public String txtBusiness; 
	
	
	public BusareaInfo() {
		super();
		
		codBusiness = DefaultValue.number();
	}
	
	
	
	public static BusareaInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BusareaInfo.class);
	}
	
	
	
	public static List<BusareaInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BusareaInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codBusiness    ^ (codBusiness    >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BusareaInfo))
			return false;
		
		
		BusareaInfo obj = (BusareaInfo) o;		
		return (codBusiness == obj.codBusiness);
	}
}
