package br.com.mind5.payment.creditCard.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CrecardMergerPhone extends InfoMergerTemplate<CrecardInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, PhoneInfo> getVisitorHook() {
		return new CrecardVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
