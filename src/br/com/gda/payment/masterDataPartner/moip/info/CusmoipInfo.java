package br.com.gda.payment.masterDataPartner.moip.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CusmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayCustomer;
	public String ownId;
	public String fullName;
	public String email;
	public String birthDate;
	public TaxdocmoiptInfo taxDocument;
	public PhomoipInfo phone;
	public AddrmoipInfo shippingAddress;
	
	
	
	public CusmoipInfo() {
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		taxDocument = new TaxdocmoiptInfo();
		phone = new PhomoipInfo();
		shippingAddress = new AddrmoipInfo();
	}
	
	
	
	public static CusmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusmoipInfo.class);
	}
	
	
	
	public static List<CusmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusmoipInfo))
			return false;
		
		
		CusmoipInfo obj = (CusmoipInfo) o;		
		return (ownId.equals(obj.ownId));
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (ownId != null)
			result = result * 31 + ownId.hashCode();
		
		return result;
	}
}
