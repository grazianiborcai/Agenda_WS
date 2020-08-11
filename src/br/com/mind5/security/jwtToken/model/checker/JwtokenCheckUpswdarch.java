package br.com.mind5.security.jwtToken.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchCopier;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.userPasswordSearch.model.checker.UpswdarchCheckChangedBefore;

public final class JwtokenCheckUpswdarch extends ModelCheckerTemplateForwardV2<JwtokenInfo, UpswdarchInfo> {
	
	public JwtokenCheckUpswdarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UpswdarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UpswdarchCheckChangedBefore(option);
	}
	
	
	
	@Override protected UpswdarchInfo toForwardClass(JwtokenInfo baseRecord) {
		return UpswdarchCopier.copyFromJwtoken(baseRecord);
	}
}
