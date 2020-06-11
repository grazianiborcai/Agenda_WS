package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class FimgCheckMat extends ModelCheckerTemplateForwardV2<FimgInfo, MatInfo> {
	
	public FimgCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(FimgInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
