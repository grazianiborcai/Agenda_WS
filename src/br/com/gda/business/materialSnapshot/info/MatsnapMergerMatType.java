package br.com.gda.business.materialSnapshot.info;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatsnapMergerMatType extends InfoMergerTemplate<MatsnapInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitorV2<MatsnapInfo, MatTypeInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
