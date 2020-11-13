package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class FimgCheckUsername extends ModelCheckerTemplateForward<FimgInfo, UsernameInfo> {
	
	public FimgCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(FimgInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
