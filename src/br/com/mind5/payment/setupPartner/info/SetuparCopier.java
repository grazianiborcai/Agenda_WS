package br.com.mind5.payment.setupPartner.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class SetuparCopier {	
	public static SetuparInfo copyFromPaymoip(PaymoipInfo source) {
		InfoCopier<SetuparInfo, PaymoipInfo> copier = new SetuparCopyPaymoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromPaymoip(List<PaymoipInfo> sources) {
		InfoCopier<SetuparInfo, PaymoipInfo> copier = new SetuparCopyPaymoip();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static SetuparInfo copyFromMultmoip(MultmoipInfo source) {
		InfoCopier<SetuparInfo, MultmoipInfo> copier = new SetuparCopyMultmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromMultmoip(List<MultmoipInfo> sources) {
		InfoCopier<SetuparInfo, MultmoipInfo> copier = new SetuparCopyMultmoip();
		return copier.makeCopy(sources);
	}	
}
