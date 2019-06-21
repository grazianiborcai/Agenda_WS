package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;

final class PayordMergerStoparnap extends InfoMergerTemplate<PayordInfo, StoparnapInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, StoparnapInfo> getVisitorHook() {
		return new PayordVisiMergeStoparnap();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
