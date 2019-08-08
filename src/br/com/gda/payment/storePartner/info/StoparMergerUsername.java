package br.com.gda.payment.storePartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class StoparMergerUsername extends InfoMergerTemplate<StoparInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, UsernameInfo> getVisitorHook() {
		return new StoparVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
