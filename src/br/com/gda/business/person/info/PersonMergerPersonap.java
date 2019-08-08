package br.com.gda.business.person.info;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class PersonMergerPersonap extends InfoMergerTemplate<PersonInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor<PersonInfo, PersonapInfo> getVisitorHook() {
		return new PersonVisiMergePersonap();
	}
}
