package br.com.mind5.business.orderSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdnapMergerToSelect extends InfoMergerTemplate_<OrdnapInfo, OrdnapInfo> {

	@Override protected InfoMergerVisitor_<OrdnapInfo, OrdnapInfo> getVisitorHook() {
		return new OrdnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
