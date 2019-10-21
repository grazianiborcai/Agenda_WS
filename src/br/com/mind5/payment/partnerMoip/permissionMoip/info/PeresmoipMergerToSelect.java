package br.com.mind5.payment.partnerMoip.permissionMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PeresmoipMergerToSelect extends InfoMergerTemplate<PeresmoipInfo, PeresmoipInfo> {

	@Override protected InfoMergerVisitor<PeresmoipInfo, PeresmoipInfo> getVisitorHook() {
		return new PeresmoipVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PeresmoipInfo> getUniquifierHook() {
		return new PeresmoipUniquifier();
	}
}
