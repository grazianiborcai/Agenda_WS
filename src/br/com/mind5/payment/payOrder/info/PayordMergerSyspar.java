package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class PayordMergerSyspar extends InfoMergerTemplate_<PayordInfo, SysparInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, SysparInfo> getVisitorHook() {
		return new PayordVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
