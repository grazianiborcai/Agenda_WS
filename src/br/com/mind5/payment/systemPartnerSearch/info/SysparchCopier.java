package br.com.mind5.payment.systemPartnerSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class SysparchCopier {	
	public static SysparchInfo copyFromRefumoip(RefumoipInfo source) {
		InfoCopier<SysparchInfo, RefumoipInfo> copier = new SysparchCopyRefumoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SysparchInfo> copyFromRefumoip(List<RefumoipInfo> sources) {
		InfoCopier<SysparchInfo, RefumoipInfo> copier = new SysparchCopyRefumoip();
		return copier.makeCopy(sources);
	}
}
