package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatCheckMatoup extends ModelCheckerTemplateForwardV2<MatInfo, MatoupInfo> {
	
	public MatCheckMatoup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatoupInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoupCheckExist(option);
	}
	
	
	
	@Override protected MatoupInfo toForwardClass(MatInfo baseRecord) {
		return MatoupInfo.copyFrom(baseRecord);
	}
}
