package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class CusparMergerUserap extends InfoMergerTemplate<CusparInfo, UserapInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, UserapInfo> getVisitorHook() {
		return new CusparVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
