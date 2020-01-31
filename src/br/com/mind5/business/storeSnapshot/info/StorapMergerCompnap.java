package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerCompnap extends InfoMergerTemplate_<StorapInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, CompnapInfo> getVisitorHook() {
		return new StorapVisiMergeCompnap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
