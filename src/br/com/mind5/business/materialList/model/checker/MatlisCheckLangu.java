package br.com.mind5.business.materialList.model.checker;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatlisCheckLangu extends ModelCheckerTemplateForward<MatlisInfo, LanguInfo> {
	
	public MatlisCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatlisInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
