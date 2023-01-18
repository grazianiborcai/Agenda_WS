package br.com.mind5.business.bankAccountSnapshot.model.checker;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BankaccnapCheckLangu extends ModelCheckerTemplateForward<BankaccnapInfo, LanguInfo> {
	
	public BankaccnapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(BankaccnapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
