package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PeresmoipMergerToSelect extends InfoMergerTemplate_<PeresmoipInfo, PeresmoipInfo> {

	@Override protected InfoMergerVisitor_<PeresmoipInfo, PeresmoipInfo> getVisitorHook() {
		return new PeresmoipVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PeresmoipInfo> getUniquifierHook() {
		return new PeresmoipUniquifier();
	}
}
