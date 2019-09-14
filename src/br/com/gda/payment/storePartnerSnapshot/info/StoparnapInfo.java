package br.com.gda.payment.storePartnerSnapshot.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class StoparnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String idPayPartnerStore;
	public String codePayPartnerStore;
	public String accessToken;
	public LocalDate tokenExpiresIn;
	public String refreshToken;
	public String scope;
	public long codSnapshot;
	public String txtPayPartner;
	public String description;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String codLanguage;
	
	
	public StoparnapInfo() {
		super(StoparnapInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static StoparnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoparnapInfo.class);
	}
	
	
	
	public static List<StoparnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoparnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	 >>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoparnapInfo))
			return false;
		
		
		StoparnapInfo obj = (StoparnapInfo) o;		
		return (codOwner	  == obj.codOwner &&
				codStore 	  == obj.codStore &&
				codPayPartner == obj.codPayPartner);
	}
}
