package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CremoipCopier {		
	public static List<CremoipInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<CremoipInfo, CrecardInfo> copier = new CremoipCopyCrecard();
		return copier.makeCopy(sources);
	}
}
