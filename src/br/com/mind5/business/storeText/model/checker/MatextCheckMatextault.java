package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatextCheckMatextault extends ModelCheckerTemplateForwardV2<StorextInfo, MatextaultInfo> {
	
	public MatextCheckMatextault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatextaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatextaultCheckExist(option);
	}
	
	
	
	@Override protected MatextaultInfo toForwardClass(StorextInfo baseRecord) {
		return MatextaultInfo.copyFrom(baseRecord);
	}
}
