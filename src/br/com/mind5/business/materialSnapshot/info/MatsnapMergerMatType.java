package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatsnapMergerMatType extends InfoMergerTemplate<MatsnapInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatTypeInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
