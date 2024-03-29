package br.com.mind5.business.bankAccountSearch.model.checker;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BankaccarchCheckLangu extends ModelCheckerTemplateForward<BankaccarchInfo, LanguInfo> {
	
	public BankaccarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(BankaccarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
