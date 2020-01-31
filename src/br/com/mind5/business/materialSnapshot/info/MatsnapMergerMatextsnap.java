package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatsnapMergerMatextsnap extends InfoMergerTemplate_<MatsnapInfo, MatextsnapInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatextsnapInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatextsnap();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
