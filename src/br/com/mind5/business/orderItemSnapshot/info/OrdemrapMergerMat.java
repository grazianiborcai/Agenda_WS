package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapMergerMat extends InfoMergerTemplate<OrdemrapInfo, MatInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, MatInfo> getVisitorHook() {
		return new OrdemrapVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
