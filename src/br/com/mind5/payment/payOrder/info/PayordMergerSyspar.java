package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class PayordMergerSyspar extends InfoMergerTemplate<PayordInfo, SysparInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, SysparInfo> getVisitorHook() {
		return new PayordVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
