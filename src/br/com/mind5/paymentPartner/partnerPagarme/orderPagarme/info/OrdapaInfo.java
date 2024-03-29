package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class OrdapaInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayOrderItem;
	public int codPayPartner;
	public long codPayCustomer;
	public long codCreditCard;
	public String cardCvc;
	public PayordemInfo payordemData;
	public CrecardInfo crecardData;
	public String code;
	public String customerId;
	public String paymentMethod;
	public List<Map<String,String>> items;
	public Map<String,String> card;
	public Map<String,String> payments;
	public String responseBody;
	public Map<String,String> responseRoot;
	public List<Map<String,String>> responseItems;
	public List<Map<String,String>> responseCharges;
	public Map<String,String> responseTransaction;
	public String authorization;
	public SetuparInfo setuparData;
	public String username;
	
	
	public OrdapaInfo() {
		super();
		
		card                = DefaultValue.object();
		items               = DefaultValue.list();
		codOwner            = DefaultValue.number();
		payments            = DefaultValue.object();
		crecardData         = DefaultValue.object();
		setuparData         = DefaultValue.object();
		codPayOrder         = DefaultValue.number();
		payordemData        = DefaultValue.object();
		responseRoot        = DefaultValue.object();
		codCreditCard       = DefaultValue.number();
		responseItems       = DefaultValue.list();		
		codPayPartner       = DefaultValue.number();
		codPayCustomer		= DefaultValue.number();
		codPayOrderItem     = DefaultValue.number();
		responseCharges     = DefaultValue.list();
		responseTransaction = DefaultValue.object();
	}
	
	
	
	public static OrdapaInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdapaInfo.class);
	}
	
	
	
	public static List<OrdapaInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdapaInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdapaInfo deepCopy = (OrdapaInfo) super.clone();
		
		deepCopy.setuparData = CloneUtil.cloneRecord(setuparData, this.getClass());
		deepCopy.payordemData  = CloneUtil.cloneRecord(payordemData , this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;

		result = result * 31 + (int) (codOwner 	  	  ^ (codOwner 	     >>> 32));
		result = result * 31 + (int) (codPayOrder     ^ (codPayOrder     >>> 32));
		result = result * 31 + (int) (codPayOrderItem ^ (codPayOrderItem >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdapaInfo))
			return false;
		
		
		OrdapaInfo obj = (OrdapaInfo) o;
		return (codOwner	    == obj.codOwner 	&&
				codPayOrder     == obj.codPayOrder	&&
				codPayOrderItem == obj.codPayOrderItem);
	}
}
