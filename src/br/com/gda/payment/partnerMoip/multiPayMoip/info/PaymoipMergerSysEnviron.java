package br.com.gda.payment.partnerMoip.multiPayMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PaymoipMergerSysEnviron extends InfoMergerTemplate<PaymoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitorV2<PaymoipInfo, SysEnvironInfo> getVisitorHook() {
		return new PaymoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<PaymoipInfo> getUniquifierHook() {
		return new PaymoipUniquifier();
	}
}
