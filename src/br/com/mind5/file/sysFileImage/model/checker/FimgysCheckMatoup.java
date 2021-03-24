package br.com.mind5.file.sysFileImage.model.checker;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class FimgysCheckMatoup extends ModelCheckerTemplateForward<FimgysInfo, MatoupInfo> {
	
	public FimgysCheckMatoup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoupInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoupCheckExist(option);
	}
	
	
	
	@Override protected MatoupInfo toForwardClass(FimgysInfo baseRecord) {
		return MatoupInfo.copyFrom(baseRecord);
	}
}
