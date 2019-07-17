package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class MultmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;	
	public String feeReceiver;
	public double feeAmount;
	public String codFeeCurrency;
	public char codFeeCateg;
	public String txtFeeCateg;
	public String codPaymentStatus;	
	public List<PayordemInfo> payordems;
	public CusparInfo cusparData;
	public SysparInfo sysparData;
	public List<OrdmoipInfo> ordmoips;
	public String codLanguage;
	public String username;
	
	
	public MultmoipInfo () {
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		feeAmount = 0;
		codFeeCateg = DefaultValue.character();
		codLanguage = DefaultValue.language();
		payordems = DefaultValue.list();
		cusparData = DefaultValue.object();
		sysparData = DefaultValue.object();
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
		
		return result;
	}	
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MultmoipInfo))
			return false;
		
		
		MultmoipInfo obj = (MultmoipInfo) o;		
		return (super.isRecordEqual(this, obj));
	}
}
