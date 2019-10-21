package br.com.mind5.servlet.filter.authentication;

import java.util.List;

import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.model.decisionTree.RootUauthUpswd;

final class AuthPwrd extends DeciTreeOneCallTemplate<UauthInfo> {

	public AuthPwrd(UauthInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	public AuthPwrd(List<UauthInfo> recordInfos) {
		super(recordInfos);
	}
	
	
	
	@Override protected DeciTree<UauthInfo> getTreeHook(DeciTreeOption<UauthInfo> optionTree) {
		return new RootUauthUpswd(optionTree);
	}
}
