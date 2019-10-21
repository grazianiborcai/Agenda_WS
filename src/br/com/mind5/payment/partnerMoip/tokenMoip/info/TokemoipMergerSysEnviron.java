package br.com.mind5.payment.partnerMoip.tokenMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class TokemoipMergerSysEnviron extends InfoMergerTemplate<TokemoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<TokemoipInfo, SysEnvironInfo> getVisitorHook() {
		return new TokemoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
