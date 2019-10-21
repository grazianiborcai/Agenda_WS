package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class PersonMergerUsername extends InfoMergerTemplate<PersonInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<PersonInfo, UsernameInfo> getVisitorHook() {
		return new PersonVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PersonInfo> getUniquifierHook() {
		return new PersonUniquifier();
	}	
}
