package br.com.gda.payment.permissionMoip.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PeresmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public boolean isExpected;
	public String code;
	public LocalDateTime lastChanged;
	public String codLanguage;
	public String username;
	
	
	public PeresmoipInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		isExpected = DefaultValue.boole();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static PeresmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PeresmoipInfo.class);
	}
	
	
	
	public static List<PeresmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PeresmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PeresmoipInfo))
			return false;
		
		
		PeresmoipInfo obj = (PeresmoipInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore	);
	}
}
