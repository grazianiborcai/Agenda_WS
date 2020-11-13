package br.com.mind5.business.materialStoreSnapshot.model.checker;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatorapCheckLangu extends ModelCheckerTemplateForward<MatorapInfo, LanguInfo> {
	
	public MatorapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatorapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
