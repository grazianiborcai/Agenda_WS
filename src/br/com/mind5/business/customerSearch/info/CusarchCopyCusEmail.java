package br.com.mind5.business.customerSearch.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CusarchCopyCusEmail extends InfoCopierTemplate<CusarchInfo, CusInfo>{
	
	public CusarchCopyCusEmail() {
		super();
	}
	
	
	
	@Override protected CusarchInfo makeCopyHook(CusInfo source) {
		CusarchInfo result = new CusarchInfo();
		
		result.codOwner = source.codOwner;	
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		if (source.personData == null)
			return result;
		
		result.personData = new PersonInfo();
		result.personData.email = source.personData.email;
		
		return result;
	}
}
