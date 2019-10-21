package br.com.mind5.business.person.info;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PersonMergerGender extends InfoMergerTemplate<PersonInfo, GenderInfo> {

	@Override protected InfoMergerVisitor<PersonInfo, GenderInfo> getVisitorHook() {
		return new PersonVisiMergeGender();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}
}
