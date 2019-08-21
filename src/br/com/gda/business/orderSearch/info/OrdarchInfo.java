package br.com.gda.business.orderSearch.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrdarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codOrder;	
	public String codOrderExt;	
	public long codCustomer;
	public long codUser;
	public String codOrderStatus;
	public String txtOrderStatus;
	public long codPayOrder;
	public String codLanguage;
	public String username;
	
	
	
	public OrdarchInfo() {
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();				
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static OrdarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdarchInfo.class);
	}
	
	
	
	public static List<OrdarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codOrder ^ (codOrder >>> 32));
		result = result * 31 + (int) (codUser  ^ (codUser  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdarchInfo))
			return false;
		
		
		OrdarchInfo obj = (OrdarchInfo) o;		
		return (codOwner    == obj.codOwner && 
				codOrder 	== obj.codOrder &&
				codUser     == obj.codUser		);
	}
}
