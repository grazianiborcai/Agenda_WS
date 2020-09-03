package br.com.mind5.business.calendarCatalogue.model.checker;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CalgueCheckMat extends ModelCheckerTemplateForwardV2<CalgueInfo, MatInfo> {
	
	public CalgueCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(CalgueInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
