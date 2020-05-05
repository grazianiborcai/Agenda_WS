package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedineCheckMatore extends ModelCheckerTemplateForwardV2<SchedineInfo, MatoreInfo> {
	
	public SchedineCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(SchedineInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
