package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistUsername;

public final class EmpCheckUserarch extends ModelCheckerTemplateForwardV2<EmpInfo, UserarchInfo> {
	
	public EmpCheckUserarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistUsername(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(EmpInfo baseRecord) {
		return UserarchCopier.copyFromEmp(baseRecord);
	}
}
