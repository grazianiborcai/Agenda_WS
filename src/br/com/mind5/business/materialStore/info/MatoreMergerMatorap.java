package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreMergerMatorap extends InfoMergerTemplate_<MatoreInfo, MatorapInfo> {

	@Override protected InfoMergerVisitor_<MatoreInfo, MatorapInfo> getVisitorHook() {
		return new MatoreVisiMergeMatorap();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}
}
