package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PayordMergerCuspar extends InfoMergerTemplate_<PayordInfo, CusparInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, CusparInfo> getVisitorHook() {
		return new PayordVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
