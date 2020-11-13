package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpmatCheckLangu extends ModelCheckerTemplateForward<EmpmatInfo, LanguInfo> {
	
	public EmpmatCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmpmatInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
