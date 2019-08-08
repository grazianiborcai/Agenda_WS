package br.com.gda.payment.partnerMoip.refundMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class RefumoipMergerSysEnviron extends InfoMergerTemplate<RefumoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<RefumoipInfo, SysEnvironInfo> getVisitorHook() {
		return new RefumoipVisiMergeSysEnviron();
	}
}
