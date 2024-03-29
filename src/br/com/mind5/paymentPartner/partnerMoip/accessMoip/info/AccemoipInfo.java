package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.moip.models.Setup;

public final class AccemoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codPayPartner;
	public String url;
	public MktparInfo sysparData;
	public SetuparInfo setuparData;
	public Setup setup;
	public String[] scopes;
	public String recordMode;
	public String username;
	public String codSysEnviron;
	
	
	public AccemoipInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		sysparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static AccemoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AccemoipInfo.class);
	}
	
	
	
	public static List<AccemoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AccemoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		AccemoipInfo deepCopy = (AccemoipInfo) super.clone();
		
		deepCopy.sysparData = CloneUtil.cloneRecord(deepCopy.sysparData, this.getClass());
		deepCopy.setuparData = CloneUtil.cloneRecord(deepCopy.setuparData, this.getClass());
		
		return deepCopy;
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
		
		
		if (!(o instanceof AccemoipInfo))
			return false;
		
		
		AccemoipInfo obj = (AccemoipInfo) o;		
		return (codOwner	  == obj.codOwner &&
				codStore 	  == obj.codStore &&
				codPayPartner == obj.codPayPartner);
	}
}
