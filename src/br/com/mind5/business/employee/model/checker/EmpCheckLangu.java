package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpCheckLangu extends ModelCheckerTemplateForward<EmpInfo, LanguInfo> {
	
	public EmpCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmpInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
