package br.com.gda.payment.partnerMoip.permissionMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.tokenMoip.info.TokemoipInfo;

final class PeresmoipMergerTokemoip extends InfoMergerTemplate<PeresmoipInfo, TokemoipInfo> {

	@Override protected InfoMergerVisitor<PeresmoipInfo, TokemoipInfo> getVisitorHook() {
		return new PeresmoipVisiMergeTokemoip();
	}
	
	
	
	@Override protected InfoUniquifier<PeresmoipInfo> getUniquifierHook() {
		return new PeresmoipUniquifier();
	}
}
