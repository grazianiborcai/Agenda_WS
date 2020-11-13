package br.com.mind5.business.employeeWorkTimeRange.model.checker;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpworgCheckLangu extends ModelCheckerTemplateForward<EmpworgInfo, LanguInfo> {
	
	public EmpworgCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmpworgInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
