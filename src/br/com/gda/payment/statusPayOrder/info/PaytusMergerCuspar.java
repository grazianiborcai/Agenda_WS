package br.com.gda.payment.statusPayOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class PaytusMergerCuspar extends InfoMergerTemplate<PaytusInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, CusparInfo> getVisitorHook() {
		return new PaytusVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
