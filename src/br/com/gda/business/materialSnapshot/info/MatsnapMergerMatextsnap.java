package br.com.gda.business.materialSnapshot.info;

import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatsnapMergerMatextsnap extends InfoMergerTemplate<MatsnapInfo, MatextsnapInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatextsnapInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatextsnap();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
