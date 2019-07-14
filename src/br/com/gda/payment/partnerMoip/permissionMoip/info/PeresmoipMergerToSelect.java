package br.com.gda.payment.partnerMoip.permissionMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PeresmoipMergerToSelect extends InfoMergerTemplate<PeresmoipInfo, PeresmoipInfo> {

	@Override protected InfoMergerVisitorV2<PeresmoipInfo, PeresmoipInfo> getVisitorHook() {
		return new PeresmoipVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PeresmoipInfo> getUniquifierHook() {
		return new PeresmoipUniquifier();
	}
}
