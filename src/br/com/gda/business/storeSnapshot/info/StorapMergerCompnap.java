package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StorapMergerCompnap extends InfoMergerTemplate<StorapInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, CompnapInfo> getVisitorHook() {
		return new StorapVisiMergeCompnap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
