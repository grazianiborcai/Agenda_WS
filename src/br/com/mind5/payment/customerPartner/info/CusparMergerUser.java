package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class CusparMergerUser extends InfoMergerTemplate<CusparInfo, UserInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, UserInfo> getVisitorHook() {
		return new CusparVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
