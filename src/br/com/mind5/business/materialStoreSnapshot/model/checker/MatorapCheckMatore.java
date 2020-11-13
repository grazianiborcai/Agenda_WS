package br.com.mind5.business.materialStoreSnapshot.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatorapCheckMatore extends ModelCheckerTemplateForward<MatorapInfo, MatoreInfo> {
	
	public MatorapCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(MatorapInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
