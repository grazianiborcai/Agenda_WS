package br.com.mind5.payment.payOrderItemSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class PayormarchCopier {	
	public static PayormarchInfo copyFromMultmoip(MultmoipInfo source) {
		InfoCopierTemplate<PayormarchInfo, MultmoipInfo> copier = new PayormarchCopyMultmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayormarchInfo> copyFromMultmoip(List<MultmoipInfo> sources) {
		InfoCopierTemplate<PayormarchInfo, MultmoipInfo> copier = new PayormarchCopyMultmoip();
		return copier.makeCopy(sources);
	}
}
