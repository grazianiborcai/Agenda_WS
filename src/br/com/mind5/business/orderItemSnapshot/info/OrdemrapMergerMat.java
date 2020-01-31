package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapMergerMat extends InfoMergerTemplate_<OrdemrapInfo, MatInfo> {

	@Override protected InfoMergerVisitor_<OrdemrapInfo, MatInfo> getVisitorHook() {
		return new OrdemrapVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
