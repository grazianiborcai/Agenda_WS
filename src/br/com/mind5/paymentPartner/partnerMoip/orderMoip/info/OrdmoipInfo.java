package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.moip.models.Setup;

public final class OrdmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public int codPayOrderItem;
	public int codPayPartner;
	public int itemNum;
	public String ownId;
	public String itemReceiver;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public String idRefundPartner;
	public String statusRefundPartner;
	public String productTxt;
	public String detailTxt;
	public PayordistInfo payordistData;
	public PayordemInfo payordemData;
	public CusparInfo cusparData;		
	public SysparInfo sysparData;
	public SetuparInfo setuparData;
	public StoparInfo stoparData;
	public Map<String, Object> subtotal;
	public Map<String, Object> amount;
	public List<Map<String, Object>> products;
	public Map<String, Object> account;
	public List<Map<String, Object>> receivers;
	public Map<String, Object> customer;
	public Map<String, Object> order;
	public Map<String, Object> response;
	public Setup setup;
	public String username;
	public String codSysEnviron;
	
	
	public OrdmoipInfo() {
		super();
		
		codOwner = DefaultValue.character();
		codPayOrder = DefaultValue.character();
		codPayOrderItem = DefaultValue.character();
		codPayPartner = DefaultValue.character();
		itemNum = DefaultValue.character();
		payordistData = DefaultValue.object();
		payordemData = DefaultValue.object();
		cusparData = DefaultValue.object();
		sysparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		stoparData = DefaultValue.object();
		products = DefaultValue.list();
		receivers = DefaultValue.list();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static OrdmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdmoipInfo.class);
	}	
	
	
	
	public static List<OrdmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdmoipInfo deepCopy = (OrdmoipInfo) super.clone();		
		
		deepCopy.payordistData = clonePayordist(deepCopy.payordistData);
		deepCopy.payordemData = clonePayordem(deepCopy.payordemData);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		deepCopy.sysparData = cloneSyspar(deepCopy.sysparData);
		deepCopy.setuparData = cloneSetupar(deepCopy.setuparData);
		deepCopy.stoparData = cloneStopar(deepCopy.stoparData);
		
		return deepCopy;
	}
	
	
	
	private PayordistInfo clonePayordist(PayordistInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PayordistInfo) recordInfo.clone();
	}
	
	
	
	private PayordemInfo clonePayordem(PayordemInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PayordemInfo) recordInfo.clone();
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
	
	
	
	private StoparInfo cloneStopar(StoparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (StoparInfo) recordInfo.clone();
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    		^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codPayOrder 		^ (codPayOrder 		>>> 32));
		result = result * 31 + (int) (codPayOrderItem 	^ (codPayOrderItem 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdmoipInfo))
			return false;
		
		
		OrdmoipInfo obj = (OrdmoipInfo) o;		
		return (codOwner    	== obj.codOwner    		&& 
				codPayOrder 	== obj.codPayOrder		&&
				codPayOrderItem == obj.codPayOrderItem);
	}
}
