package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisMergerMatGroup extends InfoMergerTemplate_<MatlisInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitor_<MatlisInfo, MatGroupInfo> getVisitorHook() {
		return new MatlisVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
