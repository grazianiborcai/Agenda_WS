package br.com.mind5.payment.systemPartnerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SysparchInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String idPayPartnerSystem;
	public String idPayPartnerApp;
	public String payPartnerName;
	public String urlReturn;
	public String username;
	
	
	public SysparchInfo() {
		super(SysparchInfo.class);
		
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static SysparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysparchInfo.class);
	}
	
	
	
	public static List<SysparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysparchInfo.class);
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
		
		
		if (!(o instanceof SysparchInfo))
			return false;
		
		
		SysparchInfo obj = (SysparchInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
