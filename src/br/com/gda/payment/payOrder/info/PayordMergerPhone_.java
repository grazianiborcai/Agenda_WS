package br.com.gda.payment.payOrder.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerPhone_ extends InfoMergerTemplate<PayordInfo, PhoneInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, PhoneInfo> getVisitorHook() {
		return new PayordVisiMergePhone_();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
