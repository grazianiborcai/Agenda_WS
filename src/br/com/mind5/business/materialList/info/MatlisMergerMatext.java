package br.com.mind5.business.materialList.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisMergerMatext extends InfoMergerTemplate_<MatlisInfo, MatextInfo> {

	@Override protected InfoMergerVisitor_<MatlisInfo, MatextInfo> getVisitorHook() {
		return new MatlisVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
