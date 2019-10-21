package br.com.mind5.payment.partnerMoip.orderMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class OrdmoipMergerSysEnviron extends InfoMergerTemplate<OrdmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<OrdmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new OrdmoipVisiMergeSysEnviron();
	}
}
