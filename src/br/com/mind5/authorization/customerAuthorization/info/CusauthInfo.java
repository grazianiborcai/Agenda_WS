package br.com.mind5.authorization.customerAuthorization.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CusauthInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codStore;
	public String username;
	
	
	public CusauthInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
	}
	
	
	
	public static CusauthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusauthInfo.class);
	}
	
	
	
	public static List<CusauthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusauthInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusauthInfo))
			return false;
		
		
		CusauthInfo obj = (CusauthInfo) o;		
		return (codOwner    == obj.codOwner && 
				codCustomer == obj.codCustomer);
	}
}
