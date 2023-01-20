package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class CustopaInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codPayPartner;
	public long codCustomer;
	public String id;
	public String name;
	public String email;
	public String document;
	public String documentType;
	public String type;
	public String gender;
	public String birthdate;
	public String code;
	public String authorization;
	public SetuparInfo setuparData;
	public String username;
	
	
	public CustopaInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		setuparData = DefaultValue.object();
	}
	
	
	
	public static CustopaInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CustopaInfo.class);
	}
	
	
	
	public static List<CustopaInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CustopaInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CustopaInfo deepCopy = (CustopaInfo) super.clone();
		
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
		
		
		if (!(o instanceof CustopaInfo))
			return false;
		
		
		CustopaInfo obj = (CustopaInfo) o;		
		return (isStringEqual(email, obj.email));
	}
}
