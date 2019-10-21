package br.com.mind5.business.orderSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdnapMergerToSelect extends InfoMergerTemplate<OrdnapInfo, OrdnapInfo> {

	@Override protected InfoMergerVisitor<OrdnapInfo, OrdnapInfo> getVisitorHook() {
		return new OrdnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
