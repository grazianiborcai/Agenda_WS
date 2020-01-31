package br.com.mind5.payment.partnerMoip.refundMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class RefumoipMergerSysEnviron extends InfoMergerTemplate_<RefumoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<RefumoipInfo, SysEnvironInfo> getVisitorHook() {
		return new RefumoipVisiMergeSysEnviron();
	}
}
