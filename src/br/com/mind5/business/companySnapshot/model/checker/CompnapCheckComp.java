package br.com.mind5.business.companySnapshot.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.checker.CompCheckExist;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CompnapCheckComp extends ModelCheckerTemplateForward<CompnapInfo, CompInfo> {
	
	public CompnapCheckComp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CompInfo> getCheckerHook(ModelCheckerOption option) {
		return new CompCheckExist(option);
	}
	
	
	
	@Override protected CompInfo toForwardClass(CompnapInfo baseRecord) {
		return CompInfo.copyFrom(baseRecord);
	}
}
