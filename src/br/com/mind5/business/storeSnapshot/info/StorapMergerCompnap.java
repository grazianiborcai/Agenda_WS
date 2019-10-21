package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerCompnap extends InfoMergerTemplate<StorapInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, CompnapInfo> getVisitorHook() {
		return new StorapVisiMergeCompnap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
