package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class PeresmoipCheckUsername extends ModelCheckerTemplateForwardV2<PeresmoipInfo, UsernameInfo> {
	
	public PeresmoipCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(PeresmoipInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
