package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class CusparMergerUser extends InfoMergerTemplate_<CusparInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, UserInfo> getVisitorHook() {
		return new CusparVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
