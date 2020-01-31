package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerPhonap extends InfoMergerTemplate_<StorapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, PhonapInfo> getVisitorHook() {
		return new StorapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
