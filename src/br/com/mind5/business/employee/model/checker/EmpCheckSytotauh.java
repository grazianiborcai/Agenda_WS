package br.com.mind5.business.employee.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckExist;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpCheckSytotauh extends ModelCheckerTemplateForwardV2<EmpInfo, SytotauhInfo> {
	
	public EmpCheckSytotauh(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SytotauhInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotauhCheckExist(option);
	}
	
	
	
	@Override protected SytotauhInfo toForwardClass(EmpInfo baseRecord) {
		return SytotauhInfo.copyFrom(baseRecord);
	}
}
