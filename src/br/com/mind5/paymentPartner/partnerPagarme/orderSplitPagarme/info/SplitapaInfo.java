package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class SplitapaInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayOrderItem;
	public int codPayPartner;
	public PayordInfo payordData;
	public String code;
	public String customerId;
	public String paymentMethod;
	public String amount;
	public List<Map<String,String>> items;
	public Map<String,String> creditCard;
	public Map<Map<String,String>,Map<String,String>> split;
	public String responseBody;
	public Map<String,String> responseRoot;
	public List<Map<String,String>> responseItems;
	public List<Map<String,String>> responseCharges;
	public Map<String,String> responseTransaction;
	public String authorization;
	public SetuparInfo setuparData;
	public String username;
	
	
	public SplitapaInfo() {
		super();
		
		split               = DefaultValue.object();
		items               = DefaultValue.list();
		codOwner            = DefaultValue.number();
		creditCard          = DefaultValue.object();
		payordData          = DefaultValue.object();
		setuparData         = DefaultValue.object();
		codPayOrder         = DefaultValue.number();
		responseRoot        = DefaultValue.object();
		responseItems       = DefaultValue.list();		
		codPayPartner       = DefaultValue.number();
		codPayOrderItem     = DefaultValue.number();
		responseCharges     = DefaultValue.list();
		responseTransaction = DefaultValue.object();
	}
	
	
	
	public static SplitapaInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SplitapaInfo.class);
	}
	
	
	
	public static List<SplitapaInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SplitapaInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SplitapaInfo deepCopy = (SplitapaInfo) super.clone();
		
		deepCopy.setuparData = CloneUtil.cloneRecord(setuparData, this.getClass());
		deepCopy.payordData  = CloneUtil.cloneRecord(payordData , this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	  ^ (codOwner 	 >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SplitapaInfo))
			return false;
		
		
		SplitapaInfo obj = (SplitapaInfo) o;
		return (codOwner	== obj.codOwner 	&&
				codPayOrder == obj.codPayOrder		);
	}
}
