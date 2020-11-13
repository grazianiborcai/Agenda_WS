package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.checker.MatunitCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatCheckMatunit extends ModelCheckerTemplateForward<MatInfo, MatunitInfo> {
	
	public MatCheckMatunit(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatunitInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatunitCheckExist(option);
	}
	
	
	
	@Override protected MatunitInfo toForwardClass(MatInfo baseRecord) {
		return MatunitInfo.copyFrom(baseRecord);
	}
}
