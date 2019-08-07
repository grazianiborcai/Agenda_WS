package br.com.gda.payment.partnerMoip.tokenMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class TokemoipMergerSysEnviron extends InfoMergerTemplate<TokemoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitorV2<TokemoipInfo, SysEnvironInfo> getVisitorHook() {
		return new TokemoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
