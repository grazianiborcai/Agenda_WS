package br.com.mind5.business.person.info;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PersonMergerGender extends InfoMergerTemplate_<PersonInfo, GenderInfo> {

	@Override protected InfoMergerVisitor_<PersonInfo, GenderInfo> getVisitorHook() {
		return new PersonVisiMergeGender();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}
}
