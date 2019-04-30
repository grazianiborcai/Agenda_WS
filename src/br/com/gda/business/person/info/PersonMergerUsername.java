package br.com.gda.business.person.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.security.username.info.UsernameInfo;

final class PersonMergerUsername extends InfoMergerTemplate<PersonInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<PersonInfo, UsernameInfo> getVisitorHook() {
		return new PersonVisiMergeUsername();
	}
}
