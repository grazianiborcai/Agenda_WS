package br.com.gda.payment.systemPartner.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class SysparInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String idPayPartnerSystem;
	public String idPayPartnerApp;
	public String payPartnerName;
	public String urlReturn;
	
	
	public SysparInfo() {
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static SysparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysparInfo.class);
	}
	
	
	
	public static List<SysparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysparInfo.class);
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
		
		
		if (!(o instanceof SysparInfo))
			return false;
		
		
		SysparInfo obj = (SysparInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
