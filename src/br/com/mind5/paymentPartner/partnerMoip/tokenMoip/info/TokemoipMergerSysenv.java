package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class TokemoipMergerSysenv extends InfoMergerTemplate_<TokemoipInfo, SysenvInfo> {

	@Override protected InfoMergerVisitor_<TokemoipInfo, SysenvInfo> getVisitorHook() {
		return new TokemoipVisiMergeSysenv();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
