package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerPersonap extends InfoMergerTemplate_<StorapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, PersonapInfo> getVisitorHook() {
		return new StorapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
