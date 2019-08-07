package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MultmoipMergerSysEnviron extends InfoMergerTemplate<MultmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitorV2<MultmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new MultmoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
