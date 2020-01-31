package br.com.mind5.business.person.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PersonMergerPersonap extends InfoMergerTemplate_<PersonInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor_<PersonInfo, PersonapInfo> getVisitorHook() {
		return new PersonVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}
}
