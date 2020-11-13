package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.checker.MamovypeCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatmovCheckMamovype extends ModelCheckerTemplateForward<MatmovInfo, MamovypeInfo> {
	
	public MatmovCheckMamovype(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MamovypeInfo> getCheckerHook(ModelCheckerOption option) {
		return new MamovypeCheckExist(option);
	}
	
	
	
	@Override protected MamovypeInfo toForwardClass(MatmovInfo baseRecord) {
		return MamovypeInfo.copyFrom(baseRecord);
	}
}
