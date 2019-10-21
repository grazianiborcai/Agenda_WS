package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class CrecardMergerUsername extends InfoMergerTemplate<CrecardInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, UsernameInfo> getVisitorHook() {
		return new CrecardVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
