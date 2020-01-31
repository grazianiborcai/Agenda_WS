package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class StoparMergerUsername extends InfoMergerTemplate_<StoparInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<StoparInfo, UsernameInfo> getVisitorHook() {
		return new StoparVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
