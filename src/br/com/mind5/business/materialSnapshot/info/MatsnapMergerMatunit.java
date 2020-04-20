package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

final class MatsnapMergerMatunit extends InfoMergerTemplate_<MatsnapInfo, MatunitInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatunitInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatunit();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
