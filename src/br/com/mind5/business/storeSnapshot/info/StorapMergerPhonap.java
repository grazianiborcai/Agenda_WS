package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerPhonap extends InfoMergerTemplate<StorapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, PhonapInfo> getVisitorHook() {
		return new StorapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
