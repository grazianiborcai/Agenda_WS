package br.com.mind5.file.fileImageList.model.checker;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class FimistCheckLangu extends ModelCheckerTemplateForward<FimistInfo, LanguInfo> {
	
	public FimistCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(FimistInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
