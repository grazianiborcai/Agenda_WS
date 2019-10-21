package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PersonMergerToUpdate extends InfoMergerTemplate<PersonInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<PersonInfo, PersonInfo> getVisitorHook() {
		return new PersonVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}
}
