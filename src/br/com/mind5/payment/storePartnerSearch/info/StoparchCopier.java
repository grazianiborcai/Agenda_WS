package br.com.mind5.payment.storePartnerSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StoparchCopier {	
	public static StoparchInfo copyFromRefumoip(RefumoipInfo source) {
		InfoCopier<StoparchInfo, RefumoipInfo> copier = new StoparchCopyRefumoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoparchInfo> copyFromRefumoip(List<RefumoipInfo> sources) {
		InfoCopier<StoparchInfo, RefumoipInfo> copier = new StoparchCopyRefumoip();
		return copier.makeCopy(sources);
	}
}
