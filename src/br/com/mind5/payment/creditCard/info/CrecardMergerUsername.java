package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class CrecardMergerUsername extends InfoMergerTemplate_<CrecardInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<CrecardInfo, UsernameInfo> getVisitorHook() {
		return new CrecardVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
