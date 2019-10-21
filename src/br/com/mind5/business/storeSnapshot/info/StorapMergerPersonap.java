package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerPersonap extends InfoMergerTemplate<StorapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, PersonapInfo> getVisitorHook() {
		return new StorapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
