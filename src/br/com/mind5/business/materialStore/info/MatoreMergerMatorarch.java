package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreMergerMatorarch extends InfoMergerTemplate_<MatoreInfo, MatorarchInfo> {

	@Override protected InfoMergerVisitor_<MatoreInfo, MatorarchInfo> getVisitorHook() {
		return new MatoreVisiMergeMatorarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
