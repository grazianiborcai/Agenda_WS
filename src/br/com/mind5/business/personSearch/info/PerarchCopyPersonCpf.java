package br.com.mind5.business.personSearch.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PerarchCopyPersonCpf extends InfoCopierTemplate<PerarchInfo, PersonInfo>{
	
	public PerarchCopyPersonCpf() {
		super();
	}
	
	
	
	@Override protected PerarchInfo makeCopyHook(PersonInfo source) {
		PerarchInfo result = new PerarchInfo();
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		result.codEntityCateg = source.codEntityCateg;
		result.cpf = source.cpf;
		
		return result;
	}
}
