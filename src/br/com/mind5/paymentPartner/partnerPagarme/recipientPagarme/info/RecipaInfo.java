package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class RecipaInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codPayPartner;
	public String id;
	public String name;
	public String email;
	public String description;
	public String document;
	public String type;
	public String code;
	public String authorization;
	public SetuparInfo setuparData;
	
	
	public RecipaInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		setuparData = DefaultValue.object();
	}
	
	
	
	public static RecipaInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RecipaInfo.class);
	}
	
	
	
	public static List<RecipaInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RecipaInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		RecipaInfo deepCopy = (RecipaInfo) super.clone();
		
		deepCopy.setuparData = CloneUtil.cloneRecord(setuparData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (email != null)		
			result = result * 31 + email.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RecipaInfo))
			return false;
		
		
		RecipaInfo obj = (RecipaInfo) o;		
		return (isStringEqual(email, obj.email));
	}
}
