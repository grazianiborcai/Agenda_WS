package br.com.gda.payment.creditCard.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CrecardMergerPhone extends InfoMergerTemplate<CrecardInfo, PhoneInfo> {

	@Override protected InfoMergerVisitorV2<CrecardInfo, PhoneInfo> getVisitorHook() {
		return new CrecardVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
