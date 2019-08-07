package br.com.gda.payment.partnerMoip.accessMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class AccemoipMergerSysEnviron extends InfoMergerTemplate<AccemoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitorV2<AccemoipInfo, SysEnvironInfo> getVisitorHook() {
		return new AccemoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
