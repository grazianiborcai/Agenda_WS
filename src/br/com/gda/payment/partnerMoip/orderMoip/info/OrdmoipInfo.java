package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class OrdmoipInfo extends InfoRecord implements Cloneable {
	public String orderId;
	public PayordemInfo payordemData;
	public StoparInfo stoparData;
	public CusparInfo cusparData;
	public FeewnerInfo feewnerData;
	public SysparInfo sysparData;
	public Map<String, Object> subtotal;
	public Map<String, Object> amount;
	public List<Map<String, Object>> products;
	public Map<String, Object> account;
	public List<Map<String, Object>> receivers;
	public Map<String, Object> customer;
	public Map<String, Object> order;
	
	
	public OrdmoipInfo() {
		payordemData = DefaultValue.object();
		stoparData = DefaultValue.object();
		cusparData = DefaultValue.object();
		products = DefaultValue.list();
		receivers = DefaultValue.list();
	}
	
	
	
	public static OrdmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdmoipInfo.class);
	}	
	
	
	
	public static List<OrdmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdmoipInfo deepCopy = (OrdmoipInfo) super.clone();		
		deepCopy.payordemData = clonePayordem(deepCopy.payordemData);
		deepCopy.stoparData = cloneStopar(deepCopy.stoparData);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		deepCopy.feewnerData = cloneFeewner(deepCopy.feewnerData);
		deepCopy.sysparData = cloneSyspar(deepCopy.sysparData);
		
		return deepCopy;
	}
	
	
	
	private PayordemInfo clonePayordem(PayordemInfo payordem) throws CloneNotSupportedException {
		if (payordem == null)
			return null;
		
		return (PayordemInfo) payordem.clone();
	}
	
	
	
	private StoparInfo cloneStopar(StoparInfo stopar) throws CloneNotSupportedException {
		if (stopar == null)
			return null;
		
		return (StoparInfo) stopar.clone();
	}
	
	
	
	private CusparInfo cloneCuspar(CusparInfo cuspar) throws CloneNotSupportedException {
		if (cuspar == null)
			return null;
		
		return (CusparInfo) cuspar.clone();
	}	
	
	
	
	private FeewnerInfo cloneFeewner(FeewnerInfo feewner) throws CloneNotSupportedException {
		if (feewner == null)
			return null;
		
		return (FeewnerInfo) feewner.clone();
	}	
	
	
	
	private SysparInfo cloneSyspar(SysparInfo syspar) throws CloneNotSupportedException {
		if (syspar == null)
			return null;
		
		return (SysparInfo) syspar.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (payordemData != null)
			result = result * 31 * (payordemData.hashCode() ^ (payordemData.hashCode() >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdmoipInfo))
			return false;
		
		
		OrdmoipInfo obj = (OrdmoipInfo) o;		
		return (super.isRecordEqual(this, obj));
	}
}
