package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class CusparMergerUsername extends InfoMergerTemplate<CusparInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, UsernameInfo> getVisitorHook() {
		return new CusparVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
