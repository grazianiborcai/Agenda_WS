package br.com.gda.payment.partnerMoip.refundMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class RefumoipMergerSysEnviron extends InfoMergerTemplate<RefumoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitorV2<RefumoipInfo, SysEnvironInfo> getVisitorHook() {
		return new RefumoipVisiMergeSysEnviron();
	}
}
