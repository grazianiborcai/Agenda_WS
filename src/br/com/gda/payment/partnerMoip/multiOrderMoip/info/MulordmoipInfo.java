package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class MulordmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codCreditCard;
	public int codPayPartner;
	public List<PayordemInfo> payordems;
	public StoparInfo stoparData;
	public CusparInfo cusparData;
	public FeewnerInfo feewnerData;
	public SysparInfo sysparData;
	public List<OrdmoipInfo> ordmoips;
	public String codLanguage;
	public String username;
	
	
	public MulordmoipInfo () {
		codOwner = DefaultValue.number();
		codCreditCard = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		payordems = DefaultValue.list();
		stoparData = DefaultValue.object();
		cusparData = DefaultValue.object();
		feewnerData = DefaultValue.object();
		sysparData = DefaultValue.object();
		ordmoips = DefaultValue.list();
	}
	
	
	
	public static MulordmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MulordmoipInfo.class);
	}
	
	
	
	public static List<MulordmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MulordmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MulordmoipInfo deepCopy = (MulordmoipInfo) super.clone();
		
		deepCopy.payordems = clonePayordems(deepCopy.payordems);
		deepCopy.stoparData = cloneStopar(deepCopy.stoparData);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		deepCopy.feewnerData = cloneFeewner(deepCopy.feewnerData);
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
	
	
	
	private StoparInfo cloneStopar(StoparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (StoparInfo) recordInfo.clone();
	}
	
	
	
	private CusparInfo cloneCuspar(CusparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CusparInfo) recordInfo.clone();
	}	
	
	
	
	private FeewnerInfo cloneFeewner(FeewnerInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (FeewnerInfo) recordInfo.clone();
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
		
		
		if (!(o instanceof MulordmoipInfo))
			return false;
		
		
		MulordmoipInfo obj = (MulordmoipInfo) o;		
		return (super.isRecordEqual(this, obj));
	}
}
