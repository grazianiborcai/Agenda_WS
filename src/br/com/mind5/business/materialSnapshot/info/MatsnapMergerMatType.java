package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatsnapMergerMatType extends InfoMergerTemplate_<MatsnapInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatTypeInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
