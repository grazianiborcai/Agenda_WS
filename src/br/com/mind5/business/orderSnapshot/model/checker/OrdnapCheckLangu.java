package br.com.mind5.business.orderSnapshot.model.checker;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdnapCheckLangu extends ModelCheckerTemplateForward<OrdnapInfo, LanguInfo> {
	
	public OrdnapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(OrdnapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
