package br.com.gda.business.materialSnapshot.info;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatsnapMergerMatGroup extends InfoMergerTemplate<MatsnapInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatGroupInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
