package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatsnapMergerToSelect extends InfoMergerTemplate<MatsnapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatsnapInfo> getVisitorHook() {
		return new MatsnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
