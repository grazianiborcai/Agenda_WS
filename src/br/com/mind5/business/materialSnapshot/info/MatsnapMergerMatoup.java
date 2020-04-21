package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatsnapMergerMatoup extends InfoMergerTemplate_<MatsnapInfo, MatoupInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatoupInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatoup();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
