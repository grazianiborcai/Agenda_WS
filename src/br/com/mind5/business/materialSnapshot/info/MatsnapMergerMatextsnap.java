package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatsnapMergerMatextsnap extends InfoMergerTemplate<MatsnapInfo, MatextsnapInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatextsnapInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatextsnap();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
