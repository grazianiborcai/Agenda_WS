package br.com.gda.business.personSearch.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PerarchCopyPersonEmail extends InfoCopierTemplate<PerarchInfo, PersonInfo>{
	
	public PerarchCopyPersonEmail() {
		super();
	}
	
	
	
	@Override protected PerarchInfo makeCopyHook(PersonInfo source) {
		PerarchInfo result = new PerarchInfo();
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		result.codEntityCateg = source.codEntityCateg;
		result.email = source.email;
		
		return result;
	}
}
