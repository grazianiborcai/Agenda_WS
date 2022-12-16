package br.com.mind5.payment.marketplacePartnerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MktpararchInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String idPayPartnerSystem;
	public String idPayPartnerApp;
	public String payPartnerName;
	public String urlReturn;
	public String username;
	
	
	public MktpararchInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static MktpararchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MktpararchInfo.class);
	}
	
	
	
	public static List<MktpararchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MktpararchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + codPayPartner;		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MktpararchInfo))
			return false;
		
		
		MktpararchInfo obj = (MktpararchInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
