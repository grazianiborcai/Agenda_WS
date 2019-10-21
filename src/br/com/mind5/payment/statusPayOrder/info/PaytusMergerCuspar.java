package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PaytusMergerCuspar extends InfoMergerTemplate<PaytusInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, CusparInfo> getVisitorHook() {
		return new PaytusVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
