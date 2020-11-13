package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.checker.MategCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatCheckMateg extends ModelCheckerTemplateForward<MatInfo, MategInfo> {
	
	public MatCheckMateg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MategInfo> getCheckerHook(ModelCheckerOption option) {
		return new MategCheckExist(option);
	}
	
	
	
	@Override protected MategInfo toForwardClass(MatInfo baseRecord) {
		return MategInfo.copyFrom(baseRecord);
	}
}
