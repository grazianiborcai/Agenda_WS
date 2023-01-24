package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class CrecapaInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codPayPartner;
	public long codPayCustomer;
	public long codCreditCard;
	public String id;	
	public String customerId;
	public String cardNumber;
	public String nameHolder;
	public String cpfHolder;
	public String expirationMonth;
	public String expirationYear;
	public String cardCvc;
	public String creditCardBrand;
	public String label;
	public String options;
//	billing_address
	public String metadata;
	public String authorization;
	public SetuparInfo setuparData;
	public String username;
	
	
	public CrecapaInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codCreditCard = DefaultValue.number();
		setuparData = DefaultValue.object();
	}
	
	
	
	public static CrecapaInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CrecapaInfo.class);
	}
	
	
	
	public static List<CrecapaInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CrecapaInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CrecapaInfo deepCopy = (CrecapaInfo) super.clone();
		
		deepCopy.setuparData = CloneUtil.cloneRecord(setuparData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (id != null)		
			result = result * 31 + id.hashCode();
		
		if (cardNumber != null)		
			result = result * 31 + cardNumber.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CrecapaInfo))
			return false;
		
		
		CrecapaInfo obj = (CrecapaInfo) o;		
		return (isStringEqual(id        , obj.id        ) &&
				isStringEqual(cardNumber, obj.cardNumber));
	}
}
