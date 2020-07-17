package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.checker.MatunitCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatCheckMatunit extends ModelCheckerTemplateForwardV2<MatInfo, MatunitInfo> {
	
	public MatCheckMatunit(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatunitInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatunitCheckExist(option);
	}
	
	
	
	@Override protected MatunitInfo toForwardClass(MatInfo baseRecord) {
		return MatunitInfo.copyFrom(baseRecord);
	}
}
