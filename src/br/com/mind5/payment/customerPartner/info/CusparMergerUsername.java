package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class CusparMergerUsername extends InfoMergerTemplate_<CusparInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, UsernameInfo> getVisitorHook() {
		return new CusparVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
