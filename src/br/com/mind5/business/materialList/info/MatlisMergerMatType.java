package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatlisMergerMatType extends InfoMergerTemplate<MatlisInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitor<MatlisInfo, MatTypeInfo> getVisitorHook() {
		return new MatlisVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
