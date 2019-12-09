package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatoreMergerStolis extends InfoMergerTemplate<MatoreInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, StolisInfo> getVisitorHook() {
		return new MatoreVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
