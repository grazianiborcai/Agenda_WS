package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.model.action.commom.ActionStdObfuscateTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenObfuscate extends ActionStdObfuscateTemplate<JwtokenInfo> {

	public StdJwtokenObfuscate(DeciTreeOption<JwtokenInfo> option) {
		super(JwtokenInfo.class);
	}
}
