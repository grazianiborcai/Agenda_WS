package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenSuccess extends ActionStdSuccessTemplate<JwtokenInfo> {

	public StdJwtokenSuccess(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
}
