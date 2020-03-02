package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.moip.models.Setup;

public final class RefumoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public int codPayOrderItem;
	public int codPayPartner;
	public String idOrderPartner;
	public String itemReceiver;
	public String idRefundPartner;
	public String statusRefundPartner;
	public long codStore;
	public boolean isSystemReceiver;		//TODO: Remover
	public CusparInfo cusparData;
	public SetuparInfo setuparData;
	public StoparInfo stoparData;
	public Map<String, Object> response;
	public Setup setup;
	public String username;
	public String codSysEnviron;
	
	
	public RefumoipInfo() {
		super(RefumoipInfo.class);
		
		codOwner = DefaultValue.number();
		cusparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		stoparData = DefaultValue.object();
		isSystemReceiver = DefaultValue.boole();
		codStore = DefaultValue.number();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static RefumoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefumoipInfo.class);
	}	
	
	
	
	public static List<RefumoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefumoipInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		RefumoipInfo deepCopy = (RefumoipInfo) super.clone();	
		
		deepCopy.setuparData = cloneSetupar(deepCopy.setuparData);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		deepCopy.stoparData = cloneStopar(deepCopy.stoparData);
		
		return deepCopy;
	}
	
	
	
	private SetuparInfo cloneSetupar(SetuparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SetuparInfo) recordInfo.clone();
	}	
	
	
	
	private CusparInfo cloneCuspar(CusparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CusparInfo) recordInfo.clone();
	}	
	
	
	
	private StoparInfo cloneStopar(StoparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (StoparInfo) recordInfo.clone();
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (idOrderPartner != null)
			result = result * 31 * (idOrderPartner.hashCode() ^ (idOrderPartner.hashCode() >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefumoipInfo))
			return false;
		
		
		RefumoipInfo obj = (RefumoipInfo) o;		
		return (super.isStringEqual(idOrderPartner, obj.idOrderPartner));
	}	
}
