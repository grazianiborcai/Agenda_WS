package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatoreMergerMatorap extends InfoMergerTemplate<MatoreInfo, MatorapInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatorapInfo> getVisitorHook() {
		return new MatoreVisiMergeMatorap();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}
}
