package br.com.mind5.authorization.storePartitionAuthorization.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthorization;
import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SytotauhCheckStorauth extends ModelCheckerTemplateForwardV2<SytotauhInfo, StorauthInfo> {
	
	public SytotauhCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckAuthorization(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(SytotauhInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
