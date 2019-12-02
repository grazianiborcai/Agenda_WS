package br.com.mind5.business.materialList.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatlisMergerMatext extends InfoMergerTemplate<MatlisInfo, MatextInfo> {

	@Override protected InfoMergerVisitor<MatlisInfo, MatextInfo> getVisitorHook() {
		return new MatlisVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
