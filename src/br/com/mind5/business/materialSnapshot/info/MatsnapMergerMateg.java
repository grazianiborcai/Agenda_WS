package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

final class MatsnapMergerMateg extends InfoMergerTemplate_<MatsnapInfo, MategInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MategInfo> getVisitorHook() {
		return new MatsnapVisiMergeMateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
