package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatlisMergerMatGroup extends InfoMergerTemplate<MatlisInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitor<MatlisInfo, MatGroupInfo> getVisitorHook() {
		return new MatlisVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
