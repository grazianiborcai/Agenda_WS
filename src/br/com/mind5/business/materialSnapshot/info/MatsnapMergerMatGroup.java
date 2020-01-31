package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatsnapMergerMatGroup extends InfoMergerTemplate_<MatsnapInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatGroupInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
