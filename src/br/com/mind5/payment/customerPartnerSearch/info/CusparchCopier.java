package br.com.mind5.payment.customerPartnerSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparchCopier {	
	public static CusparchInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<CusparchInfo, CusparInfo> copier = new CusparchCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparchInfo> copyFromCrecard(List<CusparInfo> sources) {
		InfoCopier<CusparchInfo, CusparInfo> copier = new CusparchCopyCuspar();
		return copier.makeCopy(sources);
	}	
}
