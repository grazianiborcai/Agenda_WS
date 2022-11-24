package br.com.mind5.masterData.materialGroupOwner.model.checker;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckExist;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class MatoupowCheckMatoup extends ModelCheckerTemplateForward<MatoupowInfo, MatoupInfo> {
	
	public MatoupowCheckMatoup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoupInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoupCheckExist(option);
	}
	
	
	
	@Override protected MatoupInfo toForwardClass(MatoupowInfo baseRecord) {
		return MatoupInfo.copyFrom(baseRecord);
	}
}
