package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StorapMergerPhonap extends InfoMergerTemplate<StorapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, PhonapInfo> getVisitorHook() {
		return new StorapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
