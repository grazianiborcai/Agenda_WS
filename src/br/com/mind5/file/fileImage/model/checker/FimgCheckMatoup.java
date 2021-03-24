package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class FimgCheckMatoup extends ModelCheckerTemplateForward<FimgInfo, MatoupInfo> {
	
	public FimgCheckMatoup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoupInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoupCheckExist(option);
	}
	
	
	
	@Override protected MatoupInfo toForwardClass(FimgInfo baseRecord) {
		return MatoupInfo.copyFrom(baseRecord);
	}
}
