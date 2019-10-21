package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StoparMergerUsername extends InfoMergerTemplate<StoparInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, UsernameInfo> getVisitorHook() {
		return new StoparVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
