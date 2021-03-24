package br.com.mind5.file.sysFileImage.model.checker;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class FimgysCheckLangu extends ModelCheckerTemplateForward<FimgysInfo, LanguInfo> {
	
	public FimgysCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(FimgysInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
