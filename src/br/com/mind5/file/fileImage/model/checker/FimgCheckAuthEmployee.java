package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistEmployee;

public final class FimgCheckAuthEmployee extends ModelCheckerTemplateForward<FimgInfo, UserarchInfo> {
	
	public FimgCheckAuthEmployee(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistEmployee(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(FimgInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
