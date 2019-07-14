package br.com.gda.payment.permissionMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

final class PeresmoipMergerTokemoip extends InfoMergerTemplate<PeresmoipInfo, TokemoipInfo> {

	@Override protected InfoMergerVisitorV2<PeresmoipInfo, TokemoipInfo> getVisitorHook() {
		return new PeresmoipVisiMergeTokemoip();
	}
	
	
	
	@Override protected InfoUniquifier<PeresmoipInfo> getUniquifierHook() {
		return new PeresmoipUniquifier();
	}
}
