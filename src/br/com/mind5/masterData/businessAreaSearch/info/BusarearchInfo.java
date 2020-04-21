package br.com.mind5.masterData.businessAreaSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BusarearchInfo extends InfoRecord implements Cloneable {
	public int codBusiness;
	public String txtBusiness; 
	
	
	public BusarearchInfo() {
		super();
		
		codBusiness = DefaultValue.number();
	}
	
	
	
	public static BusarearchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BusarearchInfo.class);
	}
	
	
	
	public static List<BusarearchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BusarearchInfo.class);
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
		
		
		if (!(o instanceof BusarearchInfo))
			return false;
		
		
		BusarearchInfo obj = (BusarearchInfo) o;		
		return (codBusiness == obj.codBusiness);
	}
}
