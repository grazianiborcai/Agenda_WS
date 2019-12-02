package br.com.mind5.business.materialList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatlisMergerToSelect extends InfoMergerTemplate<MatlisInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<MatlisInfo, MatlisInfo> getVisitorHook() {
		return new MatlisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
