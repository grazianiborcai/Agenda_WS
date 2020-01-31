package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PersonMergerToSelect extends InfoMergerTemplate_<PersonInfo, PersonInfo> {

	@Override protected InfoMergerVisitor_<PersonInfo, PersonInfo> getVisitorHook() {
		return new PersonVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}
}
