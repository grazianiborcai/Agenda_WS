package br.com.gda.payment.setupPartner.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class SetuparCopier {	
	public static SetuparInfo copyFromCremoip(CremoipInfo source) {
		InfoCopier<SetuparInfo, CremoipInfo> copier = new SetuparCopyCremoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromCremoip(List<CremoipInfo> sources) {
		InfoCopier<SetuparInfo, CremoipInfo> copier = new SetuparCopyCremoip();
		return copier.makeCopy(sources);
	}	
}
