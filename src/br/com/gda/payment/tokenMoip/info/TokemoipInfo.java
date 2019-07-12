package br.com.gda.payment.tokenMoip.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;
import br.com.moip.models.Setup;

public final class TokemoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String url;
	public SysparInfo sysparData;
	public SetuparInfo setuparData;
	public StoparInfo stoparData;
	public Setup setup;
	public String[] scopes;
	public String recordMode;
	public String codLanguage;
	public String username;
	
	
	public TokemoipInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
		sysparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		stoparData = DefaultValue.object();
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
		deepCopy.stoparData = cloneStopar(deepCopy.stoparData);
		
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
	
	
	
	private StoparInfo cloneStopar(StoparInfo stopar) throws CloneNotSupportedException {
		if (stopar == null)
			return null;
		
		return (StoparInfo) stopar.clone();
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
