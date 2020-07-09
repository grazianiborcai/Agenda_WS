package br.com.mind5.authorization.customerAuthorization.model.checker;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CusauthCheckSytotin extends ModelCheckerTemplateForwardV2<CusauthInfo, SytotinInfo> {
	
	public CusauthCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(CusauthInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
