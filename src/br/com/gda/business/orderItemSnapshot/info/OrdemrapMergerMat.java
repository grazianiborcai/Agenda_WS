package br.com.gda.business.orderItemSnapshot.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdemrapMergerMat extends InfoMergerTemplate<OrdemrapInfo, MatInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, MatInfo> getVisitorHook() {
		return new OrdemrapVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
