package br.com.gda.security.userSnapshot.info;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class UserapMergerPersonap extends InfoMergerTemplate<UserapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitorV2<UserapInfo, PersonapInfo> getVisitorHook() {
		return new UserapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
