package br.com.gda.payment.creditCard.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class CrecardCopier {	
	public static CrecardInfo copyFromPayord(PayordInfo source) {
		InfoCopier<CrecardInfo, PayordInfo> copier = new CrecardCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CrecardInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<CrecardInfo, PayordInfo> copier = new CrecardCopyPayord();
		return copier.makeCopy(sources);
	}		
}
