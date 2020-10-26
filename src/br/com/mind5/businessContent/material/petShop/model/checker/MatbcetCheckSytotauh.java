package br.com.mind5.businessContent.material.petShop.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckExist;
import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatbcetCheckSytotauh extends ModelCheckerTemplateForwardV2<MatbcetInfo, SytotauhInfo> {
	
	public MatbcetCheckSytotauh(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SytotauhInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotauhCheckExist(option);
	}
	
	
	
	@Override protected SytotauhInfo toForwardClass(MatbcetInfo baseRecord) {
		return SytotauhInfo.copyFrom(baseRecord);
	}
}
