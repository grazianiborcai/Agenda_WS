package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;
import br.com.moip.models.Setup;

public final class MultmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public char codFeeCateg;
	public String txtFeeCateg;	
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public String urlSelf;
	public String urlPayCard;
	public String urlPayBoleto;
	public String amountTotalPartner;
	public String amountCurrencyPartner;
	public String cardCvc;
	public List<PayordemInfo> payordems;
	public CrecardInfo crecardData;
	public CusparInfo cusparData;
	public SysparInfo sysparData;
	public SetuparInfo setuparData;
	public List<OrdmoipInfo> ordmoips;
	public Map<String, Object> multiorder;
	public Map<String, Object> response;
	public Setup setup;
	public String codLanguage;
	public String username;
	
	
	public MultmoipInfo () {
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codFeeCateg = DefaultValue.character();
		codLanguage = DefaultValue.language();
		payordems = DefaultValue.list();
		crecardData = DefaultValue.object();
		cusparData = DefaultValue.object();
		sysparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		ordmoips = DefaultValue.list();
	}
	
	
	
	public static MultmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MultmoipInfo.class);
	}
	
	
	
	public static List<MultmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MultmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MultmoipInfo deepCopy = (MultmoipInfo) super.clone();
		
		deepCopy.payordems = clonePayordems(deepCopy.payordems);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		deepCopy.sysparData = cloneSyspar(deepCopy.sysparData);
		deepCopy.setuparData = cloneSetupar(deepCopy.setuparData);
		deepCopy.crecardData = cloneCrecard(deepCopy.crecardData);
		deepCopy.ordmoips = cloneOrdmoips(deepCopy.ordmoips);
		
		return deepCopy;
	}
	
	
	
	private List<PayordemInfo> clonePayordems(List<PayordemInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<PayordemInfo> results = new ArrayList<>();
		
		for (PayordemInfo eachRecord : recordInfos) {
			PayordemInfo clonedOrdmoip = (PayordemInfo) eachRecord.clone();
			results.add(clonedOrdmoip);
		}
		
		
		return results;
	}
	
	
	
	private CusparInfo cloneCuspar(CusparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CusparInfo) recordInfo.clone();
	}
	
	
	
	private SysparInfo cloneSyspar(SysparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SysparInfo) recordInfo.clone();
	}	
	
	
	
	private SetuparInfo cloneSetupar(SetuparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SetuparInfo) recordInfo.clone();
	}		
	
	
	
	private CrecardInfo cloneCrecard(CrecardInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CrecardInfo) recordInfo.clone();
	}		
	
	
	
	private List<OrdmoipInfo> cloneOrdmoips(List<OrdmoipInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for (OrdmoipInfo eachRecord : recordInfos) {
			OrdmoipInfo clonedOrdmoip = (OrdmoipInfo) eachRecord.clone();
			results.add(clonedOrdmoip);
		}
		
		
		return results;
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
