package br.com.mind5.business.employeeWorkTimeSnapshot.model.checker;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpwotmapCheckLangu extends ModelCheckerTemplateForward<EmpwotmapInfo, LanguInfo> {
	
	public EmpwotmapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmpwotmapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
