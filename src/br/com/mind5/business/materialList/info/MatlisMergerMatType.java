package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisMergerMatType extends InfoMergerTemplate_<MatlisInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitor_<MatlisInfo, MatTypeInfo> getVisitorHook() {
		return new MatlisVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
