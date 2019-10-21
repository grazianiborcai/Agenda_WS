package br.com.mind5.servlet.filter.authentication;

import java.util.List;

import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.model.decisionTree.RootTauthToken;

final class AuthJwtoken extends DeciTreeOneCallTemplate<TauthInfo> {

	public AuthJwtoken(TauthInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	public AuthJwtoken(List<TauthInfo> recordInfos) {
		super(recordInfos);
	}
	
	
	
	@Override protected DeciTree<TauthInfo> getTreeHook(DeciTreeOption<TauthInfo> optionTree) {
		return new RootTauthToken(optionTree);
	}
}
