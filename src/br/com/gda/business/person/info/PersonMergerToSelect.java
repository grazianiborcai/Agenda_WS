package br.com.gda.business.person.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class PersonMergerToSelect extends InfoMergerTemplate<PersonInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<PersonInfo, PersonInfo> getVisitorHook() {
		return new PersonVisiMergeToSelect();
	}
}
