package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PaytusMergerCuspar extends InfoMergerTemplate_<PaytusInfo, CusparInfo> {

	@Override protected InfoMergerVisitor_<PaytusInfo, CusparInfo> getVisitorHook() {
		return new PaytusVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
