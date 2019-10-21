package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BusinessInfo extends InfoRecord implements Cloneable {
	public int codBusiness;
	public String txtBusiness; 
	
	
	public BusinessInfo() {
		super(BusinessInfo.class);
		
		codBusiness = DefaultValue.number();
	}
	
	
	
	public static BusinessInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BusinessInfo.class);
	}
	
	
	
	public static List<BusinessInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BusinessInfo.class);
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
		
		
		if (!(o instanceof BusinessInfo))
			return false;
		
		
		BusinessInfo obj = (BusinessInfo) o;		
		return (codBusiness == obj.codBusiness);
	}
}
