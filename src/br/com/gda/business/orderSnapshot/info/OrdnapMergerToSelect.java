package br.com.gda.business.orderSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdnapMergerToSelect extends InfoMergerTemplate<OrdnapInfo, OrdnapInfo> {

	@Override protected InfoMergerVisitor<OrdnapInfo, OrdnapInfo> getVisitorHook() {
		return new OrdnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
