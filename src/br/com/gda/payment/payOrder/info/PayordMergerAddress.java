package br.com.gda.payment.payOrder.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerAddress extends InfoMergerTemplate<PayordInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, AddressInfo> getVisitorHook() {
		return new PayordVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
