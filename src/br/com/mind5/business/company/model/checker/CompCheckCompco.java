package br.com.mind5.business.company.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.model.checker.CompcoCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CompCheckCompco extends ModelCheckerTemplateForward<CompInfo, CompcoInfo> {
	
	public CompCheckCompco(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CompcoInfo> getCheckerHook(ModelCheckerOption option) {
		return new CompcoCheckExist(option);
	}
	
	
	
	@Override protected CompcoInfo toForwardClass(CompInfo baseRecord) {
		return CompcoInfo.copyFrom(baseRecord);
	}
}
