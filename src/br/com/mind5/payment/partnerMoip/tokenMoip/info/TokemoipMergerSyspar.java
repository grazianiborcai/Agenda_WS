package br.com.mind5.payment.partnerMoip.tokenMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class TokemoipMergerSyspar extends InfoMergerTemplate<TokemoipInfo, SysparInfo> {

	@Override protected InfoMergerVisitor<TokemoipInfo, SysparInfo> getVisitorHook() {
		return new TokemoipVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
