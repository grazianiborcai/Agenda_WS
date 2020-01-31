package br.com.mind5.business.materialList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisMergerToSelect extends InfoMergerTemplate_<MatlisInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<MatlisInfo, MatlisInfo> getVisitorHook() {
		return new MatlisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
