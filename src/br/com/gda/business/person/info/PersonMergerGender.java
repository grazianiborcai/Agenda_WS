package br.com.gda.business.person.info;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PersonMergerGender extends InfoMergerTemplate<PersonInfo, GenderInfo> {

	@Override protected InfoMergerVisitor<PersonInfo, GenderInfo> getVisitorHook() {
		return new PersonVisiMergeGender();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}
}
