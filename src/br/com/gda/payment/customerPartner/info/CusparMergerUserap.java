package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userSnapshot.info.UserapInfo;

final class CusparMergerUserap extends InfoMergerTemplate<CusparInfo, UserapInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, UserapInfo> getVisitorHook() {
		return new CusparVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
