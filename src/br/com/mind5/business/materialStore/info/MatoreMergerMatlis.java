package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreMergerMatlis extends InfoMergerTemplate_<MatoreInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<MatoreInfo, MatlisInfo> getVisitorHook() {
		return new MatoreVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
