package br.com.gda.servlet.filter.authentication;

import java.util.List;

import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userAuthentication.model.decisionTree.RootUauthUpswd;

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
