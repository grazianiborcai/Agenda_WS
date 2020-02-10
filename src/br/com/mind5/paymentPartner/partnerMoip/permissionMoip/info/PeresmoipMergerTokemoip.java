package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

final class PeresmoipMergerTokemoip extends InfoMergerTemplate_<PeresmoipInfo, TokemoipInfo> {

	@Override protected InfoMergerVisitor_<PeresmoipInfo, TokemoipInfo> getVisitorHook() {
		return new PeresmoipVisiMergeTokemoip();
	}
	
	
	
	@Override protected InfoUniquifier<PeresmoipInfo> getUniquifierHook() {
		return new PeresmoipUniquifier();
	}
}
