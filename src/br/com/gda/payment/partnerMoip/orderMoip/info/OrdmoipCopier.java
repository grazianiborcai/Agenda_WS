package br.com.gda.payment.partnerMoip.orderMoip.info;


import java.util.List;

import br.com.gda.info.InfoCopierOneToMany;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class OrdmoipCopier {	
	public static List<OrdmoipInfo> copyFromMultmoipToPlace(MultmoipInfo source) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToPlace();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdmoipInfo> copyFromMultmoipToPlace(List<MultmoipInfo> sources) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToPlace();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<OrdmoipInfo> copyFromMultmoipToRead(MultmoipInfo source) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToRead();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdmoipInfo> copyFromMultmoipToRead(List<MultmoipInfo> sources) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToRead();
		return copier.makeCopy(sources);
	}
}
