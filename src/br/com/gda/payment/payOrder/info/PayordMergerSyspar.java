package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.systemPartner.info.SysparInfo;

final class PayordMergerSyspar extends InfoMergerTemplate<PayordInfo, SysparInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, SysparInfo> getVisitorHook() {
		return new PayordVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
