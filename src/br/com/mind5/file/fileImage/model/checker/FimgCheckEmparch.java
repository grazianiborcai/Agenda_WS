package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckExistUser;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class FimgCheckEmparch extends ModelCheckerTemplateForward<FimgInfo, EmparchInfo> {
	
	public FimgCheckEmparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmparchCheckExistUser(option);
	}
	
	
	
	@Override protected EmparchInfo toForwardClass(FimgInfo baseRecord) {
		return EmparchInfo.copyFrom(baseRecord);
	}
}
