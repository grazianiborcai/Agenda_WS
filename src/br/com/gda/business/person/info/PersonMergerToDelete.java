package br.com.gda.business.person.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class PersonMergerToDelete extends InfoMergerTemplate<PersonInfo, PersonInfo> {

	@Override protected InfoMergerVisitorV2<PersonInfo, PersonInfo> getVisitorHook() {
		return new PersonVisiMergeToDelete();
	}
}
