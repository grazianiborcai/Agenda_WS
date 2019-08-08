package br.com.gda.payment.partnerMoip.orderMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class OrdmoipMergerSysEnviron extends InfoMergerTemplate<OrdmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<OrdmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new OrdmoipVisiMergeSysEnviron();
	}
}
