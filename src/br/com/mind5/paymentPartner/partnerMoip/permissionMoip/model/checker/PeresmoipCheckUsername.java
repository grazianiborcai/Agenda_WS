package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class PeresmoipCheckUsername extends ModelCheckerTemplateForward<PeresmoipInfo, UsernameInfo> {
	
	public PeresmoipCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(PeresmoipInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
