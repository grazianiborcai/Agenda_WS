package br.com.mind5.security.user.model.checker;

import br.com.mind5.business.employeeSearch.info.EmparchCopier;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckExistEmail;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckEmparchEmail extends ModelCheckerTemplateForward<UserInfo, EmparchInfo> {
	
	public UserCheckEmparchEmail(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmparchCheckExistEmail(option);
	}
	
	
	
	@Override protected EmparchInfo toForwardClass(UserInfo baseRecord) {
		return EmparchCopier.copyFromUserEmail(baseRecord);
	}
}
