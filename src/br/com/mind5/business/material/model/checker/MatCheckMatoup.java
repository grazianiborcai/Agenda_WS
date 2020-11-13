package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatCheckMatoup extends ModelCheckerTemplateForward<MatInfo, MatoupInfo> {
	
	public MatCheckMatoup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoupInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoupCheckExist(option);
	}
	
	
	
	@Override protected MatoupInfo toForwardClass(MatInfo baseRecord) {
		return MatoupInfo.copyFrom(baseRecord);
	}
}
