package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class PayordMergerCuspar extends InfoMergerTemplate<PayordInfo, CusparInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, CusparInfo> getVisitorHook() {
		return new PayordVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
