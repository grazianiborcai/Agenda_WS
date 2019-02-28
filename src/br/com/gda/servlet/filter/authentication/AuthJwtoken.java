package br.com.gda.servlet.filter.authentication;

import java.util.List;

import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;
import br.com.gda.security.tokenAuthentication.model.decisionTree.RootTauthToken;

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
