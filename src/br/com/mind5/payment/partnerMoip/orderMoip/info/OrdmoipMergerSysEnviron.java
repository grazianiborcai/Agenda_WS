package br.com.mind5.payment.partnerMoip.orderMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdmoipMergerSysEnviron extends InfoMergerTemplate_<OrdmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<OrdmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new OrdmoipVisiMergeSysEnviron();
	}
}
