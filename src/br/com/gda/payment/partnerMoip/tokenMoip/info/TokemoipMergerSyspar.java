package br.com.gda.payment.partnerMoip.tokenMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.systemPartner.info.SysparInfo;

final class TokemoipMergerSyspar extends InfoMergerTemplate<TokemoipInfo, SysparInfo> {

	@Override protected InfoMergerVisitor<TokemoipInfo, SysparInfo> getVisitorHook() {
		return new TokemoipVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<TokemoipInfo> getUniquifierHook() {
		return new TokemoipUniquifier();
	}
}
