package br.com.gda.business.customerSearch.info;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoCopierTemplate;

final class CusarchCopyCusCpf extends InfoCopierTemplate<CusarchInfo, CusInfo>{
	
	public CusarchCopyCusCpf() {
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
		result.personData.cpf = source.personData.cpf;
		
		return result;
	}
}
