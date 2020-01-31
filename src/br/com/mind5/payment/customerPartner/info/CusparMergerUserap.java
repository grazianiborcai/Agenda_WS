package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class CusparMergerUserap extends InfoMergerTemplate_<CusparInfo, UserapInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, UserapInfo> getVisitorHook() {
		return new CusparVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
