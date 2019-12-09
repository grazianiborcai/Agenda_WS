package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatoreMergerMatorarch extends InfoMergerTemplate<MatoreInfo, MatorarchInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatorarchInfo> getVisitorHook() {
		return new MatoreVisiMergeMatorarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
