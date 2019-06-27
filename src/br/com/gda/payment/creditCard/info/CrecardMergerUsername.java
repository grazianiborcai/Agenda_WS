package br.com.gda.payment.creditCard.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class CrecardMergerUsername extends InfoMergerTemplate<CrecardInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<CrecardInfo, UsernameInfo> getVisitorHook() {
		return new CrecardVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
