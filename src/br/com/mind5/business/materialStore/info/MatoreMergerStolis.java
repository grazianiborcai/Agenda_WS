package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreMergerStolis extends InfoMergerTemplate_<MatoreInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<MatoreInfo, StolisInfo> getVisitorHook() {
		return new MatoreVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
