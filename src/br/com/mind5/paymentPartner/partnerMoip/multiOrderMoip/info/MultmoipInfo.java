package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.moip.models.Setup;

public final class MultmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public String ownId;
	public long codCreditCard;
	public String cardCvc;
	public String idOrderPartner;
	public int codPayPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public String urlSelf;
	public String urlPayCard;
	public String urlPayBoleto;
	public String amountTotalPartner;
	public String amountCurrencyPartner;	
	public List<PayordemistInfo> payordemists;	
	public CrecardInfo crecardData;
	public SetuparInfo setuparData;
	public List<OrdmoipInfo> ordmoips;
	public Map<String, Object> multiorder;
	public Map<String, Object> response;
	public Setup setup;
	public String username;
	public String codSysEnviron;
	
	
	public MultmoipInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codCreditCard = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		payordemists = DefaultValue.list();
		crecardData = DefaultValue.object();
		setuparData = DefaultValue.object();
		ordmoips = DefaultValue.list();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static MultmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MultmoipInfo.class);
	}
	
	
	
	public static List<MultmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MultmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MultmoipInfo deepCopy = (MultmoipInfo) super.clone();
		
		deepCopy.payordemists = CloneUtil.cloneRecords(deepCopy.payordemists, this.getClass());
		deepCopy.setuparData = CloneUtil.cloneRecord(deepCopy.setuparData, this.getClass());
		deepCopy.crecardData = CloneUtil.cloneRecord(deepCopy.crecardData, this.getClass());
		deepCopy.ordmoips = CloneUtil.cloneRecords(deepCopy.ordmoips, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		
		return result;
	}	
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MultmoipInfo))
			return false;
		
		
		MultmoipInfo obj = (MultmoipInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codPayOrder == obj.codPayOrder		);
	}
}
