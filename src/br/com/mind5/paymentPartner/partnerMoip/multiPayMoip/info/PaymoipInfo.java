package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.moip.models.Setup;

public final class PaymoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String idOrderPartner;
	public long codCreditCard;
	public String cardCvc;
	public int codPayPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public CrecardInfo crecardData;
	public SysparInfo sysparData;
	public SetuparInfo setuparData;
	public Map<String, Object> creditCard;
	public Map<String, Object> fundingInstrument;
	public Map<String, Object> multipayment;
	public Map<String, Object> response;
	public Setup setup;
	public String username;
	public String codSysEnviron;
	
	
	public PaymoipInfo() {
		super(PaymoipInfo.class);
		
		codOwner = DefaultValue.number();
		codCreditCard = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		crecardData = DefaultValue.object();
		sysparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static PaymoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaymoipInfo.class);
	}
	
	
	
	public static List<PaymoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaymoipInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PaymoipInfo deepCopy = (PaymoipInfo) super.clone();
		
		deepCopy.crecardData = cloneCrecard(deepCopy.crecardData);
		deepCopy.sysparData = cloneSyspar(deepCopy.sysparData);
		deepCopy.setuparData = cloneSetupar(deepCopy.setuparData);
		
		return deepCopy;
	}
	
	
	
	private CrecardInfo cloneCrecard(CrecardInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CrecardInfo) recordInfo.clone();
	}		
	
	
	
	private SysparInfo cloneSyspar(SysparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SysparInfo) recordInfo.clone();
	}		
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (idOrderPartner != null)		
			result = result * 31 + (int) (idOrderPartner.hashCode() ^ (idOrderPartner.hashCode() >>> 32));
		
		return result;
	}	
	
	
	
	private SetuparInfo cloneSetupar(SetuparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SetuparInfo) recordInfo.clone();
	}	
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PaymoipInfo))
			return false;
		
		
		PaymoipInfo obj = (PaymoipInfo) o;		
		return (super.isStringEqual(idOrderPartner, obj.idOrderPartner));
	}
}
