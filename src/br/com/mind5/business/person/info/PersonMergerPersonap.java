package br.com.mind5.business.person.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PersonMergerPersonap extends InfoMergerTemplate<PersonInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor<PersonInfo, PersonapInfo> getVisitorHook() {
		return new PersonVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}
}
