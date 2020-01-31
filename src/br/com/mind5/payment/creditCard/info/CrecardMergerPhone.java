package br.com.mind5.payment.creditCard.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CrecardMergerPhone extends InfoMergerTemplate_<CrecardInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<CrecardInfo, PhoneInfo> getVisitorHook() {
		return new CrecardVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
