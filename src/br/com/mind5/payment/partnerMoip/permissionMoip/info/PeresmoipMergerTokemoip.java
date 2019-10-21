package br.com.mind5.payment.partnerMoip.permissionMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;

final class PeresmoipMergerTokemoip extends InfoMergerTemplate<PeresmoipInfo, TokemoipInfo> {

	@Override protected InfoMergerVisitor<PeresmoipInfo, TokemoipInfo> getVisitorHook() {
		return new PeresmoipVisiMergeTokemoip();
	}
	
	
	
	@Override protected InfoUniquifier<PeresmoipInfo> getUniquifierHook() {
		return new PeresmoipUniquifier();
	}
}
