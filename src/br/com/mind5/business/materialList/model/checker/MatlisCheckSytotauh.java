package br.com.mind5.business.materialList.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckExist;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatlisCheckSytotauh extends ModelCheckerTemplateForward<MatlisInfo, SytotauhInfo> {
	
	public MatlisCheckSytotauh(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotauhInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotauhCheckExist(option);
	}
	
	
	
	@Override protected SytotauhInfo toForwardClass(MatlisInfo baseRecord) {
		return SytotauhInfo.copyFrom(baseRecord);
	}
}
