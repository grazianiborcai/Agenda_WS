package br.com.mind5.business.material.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckExist;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatCheckSytotauh extends ModelCheckerTemplateForward<MatInfo, SytotauhInfo> {
	
	public MatCheckSytotauh(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotauhInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotauhCheckExist(option);
	}
	
	
	
	@Override protected SytotauhInfo toForwardClass(MatInfo baseRecord) {
		return SytotauhInfo.copyFrom(baseRecord);
	}
}
