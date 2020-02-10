package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.moip.models.Setup;

public final class TokemoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String idPayPartnerStore;
	public String code;
	public String accessToken;
	public LocalDate tokenExpiresIn;
	public String refreshToken;
	public String scope;
	public SysparInfo sysparData;
	public SetuparInfo setuparData;
	public Setup setup;
	public String recordMode;
	public String username;
	public String codSysEnviron;
	
	
	public TokemoipInfo() {
		super(TokemoipInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		sysparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static TokemoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TokemoipInfo.class);
	}
	
	
	
	public static List<TokemoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TokemoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		TokemoipInfo deepCopy = (TokemoipInfo) super.clone();
		
		deepCopy.sysparData = cloneSyspar(deepCopy.sysparData);
		deepCopy.setuparData = cloneSetupar(deepCopy.setuparData);
		
		return deepCopy;
	}
	
	
	
	private SysparInfo cloneSyspar(SysparInfo syspar) throws CloneNotSupportedException {
		if (syspar == null)
			return null;
		
		return (SysparInfo) syspar.clone();
	}
	
	
	
	private SetuparInfo cloneSetupar(SetuparInfo setupar) throws CloneNotSupportedException {
		if (setupar == null)
			return null;
		
		return (SetuparInfo) setupar.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	 >>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TokemoipInfo))
			return false;
		
		
		TokemoipInfo obj = (TokemoipInfo) o;		
		return (codOwner	  == obj.codOwner &&
				codStore 	  == obj.codStore &&
				codPayPartner == obj.codPayPartner);
	}
}
