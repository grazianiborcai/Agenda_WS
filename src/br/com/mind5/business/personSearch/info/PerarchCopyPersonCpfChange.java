package br.com.mind5.business.personSearch.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PerarchCopyPersonCpfChange extends InfoCopierTemplate<PerarchInfo, PersonInfo>{
	
	public PerarchCopyPersonCpfChange() {
		super();
	}
	
	
	
	@Override protected PerarchInfo makeCopyHook(PersonInfo source) {
		PerarchInfo result = new PerarchInfo();
		
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codEntityCateg = source.codEntityCateg;
		result.cpf = source.cpf;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
