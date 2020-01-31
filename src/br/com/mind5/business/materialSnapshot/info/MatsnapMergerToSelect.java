package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatsnapMergerToSelect extends InfoMergerTemplate_<MatsnapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatsnapInfo> getVisitorHook() {
		return new MatsnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
