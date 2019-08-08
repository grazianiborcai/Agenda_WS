package br.com.gda.security.userSnapshot.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class UserapCopier {	
	public static UserapInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<UserapInfo, CusparInfo> copier = new UserapCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserapInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<UserapInfo, CusparInfo> copier = new UserapCopyCuspar();
		return copier.makeCopy(sources);
	}
}
