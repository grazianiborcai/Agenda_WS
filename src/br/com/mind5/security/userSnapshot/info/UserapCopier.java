package br.com.mind5.security.userSnapshot.info;


import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class UserapCopier {	
	public static UserapInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<UserapInfo, CusparInfo> copier = new UserapCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserapInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<UserapInfo, CusparInfo> copier = new UserapCopyCuspar();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserapInfo copyFromStorap(StorapInfo source) {
		InfoCopier<UserapInfo, StorapInfo> copier = new UserapCopyStorap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserapInfo> copyFromStorap(List<StorapInfo> sources) {
		InfoCopier<UserapInfo, StorapInfo> copier = new UserapCopyStorap();
		return copier.makeCopy(sources);
	}
}
