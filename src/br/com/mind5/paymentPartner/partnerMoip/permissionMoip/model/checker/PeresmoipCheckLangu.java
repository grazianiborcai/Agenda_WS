package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckLangu extends ModelCheckerTemplateForward<PeresmoipInfo, LanguInfo> {
	
	public PeresmoipCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PeresmoipInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
