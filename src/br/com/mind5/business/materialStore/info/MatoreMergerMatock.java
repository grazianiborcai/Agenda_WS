package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreMergerMatock extends InfoMergerTemplate_<MatoreInfo, MatockInfo> {

	@Override protected InfoMergerVisitor_<MatoreInfo, MatockInfo> getVisitorHook() {
		return new MatoreVisiMergeMatock();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
