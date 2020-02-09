package br.com.mind5.payment.customerPartnerSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CusparchCopyCuspar extends InfoCopierTemplate<CusparchInfo, CusparInfo>{
	
	public CusparchCopyCuspar() {
		super();
	}
	
	
	
	@Override protected CusparchInfo makeCopyHook(CusparInfo source) {
		CusparchInfo result = new CusparchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;	
		result.codPayPartner = source.codPayPartner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
