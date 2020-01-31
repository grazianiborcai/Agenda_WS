package br.com.mind5.payment.partnerMoip.tokenMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class TokemoipMergerSysEnviron extends InfoMergerTemplate_<TokemoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<TokemoipInfo, SysEnvironInfo> getVisitorHook() {
		return new TokemoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
