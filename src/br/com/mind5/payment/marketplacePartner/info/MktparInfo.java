package br.com.mind5.payment.marketplacePartner.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MktparInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String idPayPartnerSystem;
	public String idPayPartnerApp;
	public String payPartnerName;
	public String urlReturn;
	
	
	public MktparInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static MktparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MktparInfo.class);
	}
	
	
	
	public static List<MktparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MktparInfo.class);
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
		
		
		if (!(o instanceof MktparInfo))
			return false;
		
		
		MktparInfo obj = (MktparInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
