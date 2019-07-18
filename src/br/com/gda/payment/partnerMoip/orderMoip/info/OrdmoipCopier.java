package br.com.gda.payment.partnerMoip.orderMoip.info;


import java.util.List;

import br.com.gda.info.InfoCopierOneToMany;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class OrdmoipCopier {	
	public static List<OrdmoipInfo> copyFromMultmoip(MultmoipInfo source) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdmoipInfo> copyFromMultmoip(List<MultmoipInfo> sources) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoip();
		return copier.makeCopy(sources);
	}
}
