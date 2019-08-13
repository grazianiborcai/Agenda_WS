package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StorapMergerPersonap extends InfoMergerTemplate<StorapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, PersonapInfo> getVisitorHook() {
		return new StorapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
