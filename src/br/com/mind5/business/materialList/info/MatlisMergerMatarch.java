package br.com.mind5.business.materialList.info;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatlisMergerMatarch extends InfoMergerTemplate<MatlisInfo, MatarchInfo> {

	@Override protected InfoMergerVisitor<MatlisInfo, MatarchInfo> getVisitorHook() {
		return new MatlisVisiMergeMatarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
