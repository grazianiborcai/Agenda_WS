package br.com.mind5.payment.partnerMoip.refundMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class RefumoipMergerSysEnviron extends InfoMergerTemplate<RefumoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<RefumoipInfo, SysEnvironInfo> getVisitorHook() {
		return new RefumoipVisiMergeSysEnviron();
	}
}
