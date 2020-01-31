package br.com.mind5.business.materialList.info;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisMergerMatarch extends InfoMergerTemplate_<MatlisInfo, MatarchInfo> {

	@Override protected InfoMergerVisitor_<MatlisInfo, MatarchInfo> getVisitorHook() {
		return new MatlisVisiMergeMatarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
