package br.com.mind5.business.materialSnapshot.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatsnapCheckMat extends ModelCheckerTemplateForwardV2<MatsnapInfo, MatInfo> {
	
	public MatsnapCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(MatsnapInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
