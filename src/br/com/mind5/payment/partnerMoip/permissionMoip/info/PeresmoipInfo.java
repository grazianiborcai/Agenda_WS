package br.com.mind5.payment.partnerMoip.permissionMoip.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class PeresmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public boolean isExpected;
	public String code;
	public TokemoipInfo tokemoipData;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public PeresmoipInfo() {
		super(PeresmoipInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		isExpected = DefaultValue.boole();
		tokemoipData = DefaultValue.object();
	}
	
	
	
	public static PeresmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PeresmoipInfo.class);
	}
	
	
	
	public static List<PeresmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PeresmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PeresmoipInfo deepCopy = (PeresmoipInfo) super.clone();		
		deepCopy.tokemoipData = cloneTokemoip(tokemoipData);
		
		return deepCopy;
	}
	
	
	
	private TokemoipInfo cloneTokemoip(TokemoipInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (TokemoipInfo) recordInfo.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PeresmoipInfo))
			return false;
		
		
		PeresmoipInfo obj = (PeresmoipInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore	);
	}
}
