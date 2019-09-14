package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;
import br.com.moip.models.Setup;

public final class OrdmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int itemNum;
	public String ownId;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public String idRefundPartner;
	public String statusRefundPartner;
	public char codFeeCateg;
	public String txtFeeCateg;
	public String productTxt;
	public String detailTxt;
	public PayordemInfo payordemData;
	public CusparInfo cusparData;
	public SysparInfo sysparData;
	public SetuparInfo setuparData;
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
	public String codLanguage;
	
	
	public OrdmoipInfo() {
		super(OrdmoipInfo.class);
		
		codOwner = DefaultValue.character();
		itemNum = DefaultValue.character();
		codFeeCateg = DefaultValue.character();
		payordemData = DefaultValue.object();
		cusparData = DefaultValue.object();
		sysparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		products = DefaultValue.list();
		receivers = DefaultValue.list();
		codSysEnviron = DefaultValue.getCodEnvironment();
		codLanguage = DefaultValue.language();
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
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		deepCopy.sysparData = cloneSyspar(deepCopy.sysparData);
		deepCopy.setuparData = cloneSetupar(deepCopy.setuparData);
		
		return deepCopy;
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
		return (super.isRecordEqual(payordemData, obj.payordemData));
	}
}
