package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatsnapMergerMatGroup extends InfoMergerTemplate<MatsnapInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatGroupInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
