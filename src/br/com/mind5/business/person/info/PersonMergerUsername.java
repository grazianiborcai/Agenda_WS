package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class PersonMergerUsername extends InfoMergerTemplate_<PersonInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<PersonInfo, UsernameInfo> getVisitorHook() {
		return new PersonVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}	
}
