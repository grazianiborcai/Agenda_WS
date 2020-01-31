package br.com.mind5.payment.partnerMoip.tokenMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class TokemoipMergerSyspar extends InfoMergerTemplate_<TokemoipInfo, SysparInfo> {

	@Override protected InfoMergerVisitor_<TokemoipInfo, SysparInfo> getVisitorHook() {
		return new TokemoipVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
