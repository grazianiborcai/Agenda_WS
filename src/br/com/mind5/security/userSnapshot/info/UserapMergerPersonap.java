package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserapMergerPersonap extends InfoMergerTemplate_<UserapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor_<UserapInfo, PersonapInfo> getVisitorHook() {
		return new UserapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
