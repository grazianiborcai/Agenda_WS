package br.com.gda.payment.partnerMoip.multiPayMoip.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class PaymoipCopier {	
	public static PaymoipInfo copyFromMultmoip(MultmoipInfo source) {
		InfoCopier<PaymoipInfo, MultmoipInfo> copier = new PaymoipCopyMultmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PaymoipInfo> copyFromMultmoip(List<MultmoipInfo> sources) {
		InfoCopier<PaymoipInfo, MultmoipInfo> copier = new PaymoipCopyMultmoip();
		return copier.makeCopy(sources);
	}
}
