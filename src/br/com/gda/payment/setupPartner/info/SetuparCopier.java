package br.com.gda.payment.setupPartner.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class SetuparCopier {	
	public static SetuparInfo copyFromCremoip(CremoipInfo source) {
		InfoCopier<SetuparInfo, CremoipInfo> copier = new SetuparCopyCremoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromCremoip(List<CremoipInfo> sources) {
		InfoCopier<SetuparInfo, CremoipInfo> copier = new SetuparCopyCremoip();
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
	
	
	
	public static SetuparInfo copyFromOrdmoip(OrdmoipInfo source) {
		InfoCopier<SetuparInfo, OrdmoipInfo> copier = new SetuparCopyOrdmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromOrdmoip(List<OrdmoipInfo> sources) {
		InfoCopier<SetuparInfo, OrdmoipInfo> copier = new SetuparCopyOrdmoip();
		return copier.makeCopy(sources);
	}		
}
