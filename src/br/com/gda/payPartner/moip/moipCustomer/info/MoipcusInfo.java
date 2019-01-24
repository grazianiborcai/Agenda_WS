package br.com.gda.payPartner.moip.moipCustomer.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payPartner.moip.moipMasterData.info.PhoneInfo;
import br.com.gda.payPartner.moip.moipMasterData.info.AddressInfo;
import br.com.gda.payPartner.moip.moipMasterData.info.TaxDocumentInfo;

public final class MoipcusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayCustomer;
	public String ownId;
	public String fullName;
	public String email;
	public String birthDate;
	public TaxDocumentInfo taxDocument;
	public PhoneInfo phone;
	public AddressInfo shippingAddress;
	
	
	
	public MoipcusInfo() {
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		taxDocument = new TaxDocumentInfo();
		phone = new PhoneInfo();
		shippingAddress = new AddressInfo();
	}
	
	
	
	public static MoipcusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MoipcusInfo.class);
	}
	
	
	
	public static List<MoipcusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MoipcusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MoipcusInfo))
			return false;
		
		
		MoipcusInfo obj = (MoipcusInfo) o;		
		return (ownId.equals(obj.ownId));
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (ownId != null)
			result = result * 31 + ownId.hashCode();
		
		return result;
	}
}
