package br.com.mind5.payment.payOrderSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class PayordarchCopier {		
	public static PayordarchInfo copyFromRefumoip(RefumoipInfo source) {
		InfoCopierTemplate<PayordarchInfo, RefumoipInfo> copier = new PayordarchCopyRefumoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordarchInfo> copyFromRefumoip(List<RefumoipInfo> sources) {
		InfoCopierTemplate<PayordarchInfo, RefumoipInfo> copier = new PayordarchCopyRefumoip();
		return copier.makeCopy(sources);
	}
}
