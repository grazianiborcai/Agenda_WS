package br.com.gda.payment.storePartner.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;

public final class StoparCopier {	
	public static StoparInfo copyFromPeresmoip(PeresmoipInfo source) {
		InfoCopier<StoparInfo, PeresmoipInfo> copier = new StoparCopyPeresmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoparInfo> copyFromPeresmoip(List<PeresmoipInfo> sources) {
		InfoCopier<StoparInfo, PeresmoipInfo> copier = new StoparCopyPeresmoip();
		return copier.makeCopy(sources);
	}		
}
