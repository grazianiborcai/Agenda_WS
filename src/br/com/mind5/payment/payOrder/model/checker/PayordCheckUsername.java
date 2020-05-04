package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class PayordCheckUsername extends ModelCheckerTemplateForwardV2<PayordInfo, UsernameInfo> {
	
	public PayordCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(PayordInfo baseRecord) {
		return UsernameCopier.copyFromPayord(baseRecord);
	}
}
