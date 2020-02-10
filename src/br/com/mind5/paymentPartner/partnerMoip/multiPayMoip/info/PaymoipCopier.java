package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

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
