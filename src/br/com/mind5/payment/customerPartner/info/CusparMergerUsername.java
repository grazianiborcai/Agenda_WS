package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class CusparMergerUsername extends InfoMergerTemplate<CusparInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, UsernameInfo> getVisitorHook() {
		return new CusparVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
