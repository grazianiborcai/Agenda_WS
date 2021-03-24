package br.com.mind5.file.sysFileImage.model.checker;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckExist;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class FimgCheckFimarch extends ModelCheckerTemplateForward<FimgysInfo, FimarchInfo> {
	
	public FimgCheckFimarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<FimarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new FimarchCheckExist(option);
	}
	
	
	
	@Override protected FimarchInfo toForwardClass(FimgysInfo baseRecord) {
		return FimarchInfo.copyFrom(baseRecord);
	}
}
