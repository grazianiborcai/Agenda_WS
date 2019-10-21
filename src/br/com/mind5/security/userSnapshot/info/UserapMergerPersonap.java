package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserapMergerPersonap extends InfoMergerTemplate<UserapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, PersonapInfo> getVisitorHook() {
		return new UserapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
