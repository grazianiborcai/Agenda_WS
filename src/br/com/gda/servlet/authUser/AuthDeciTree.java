package br.com.gda.servlet.authUser;

import java.util.List;

import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userAuthentication.model.decisionTree.RootUauthAuth;

final class AuthDeciTree extends DeciTreeOneCallTemplate<UauthInfo> {

	public AuthDeciTree(UauthInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	public AuthDeciTree(List<UauthInfo> recordInfos) {
		super(recordInfos);
	}
	
	
	
	@Override protected DeciTree<UauthInfo> getTreeHook(DeciTreeOption<UauthInfo> optionTree) {
		return new RootUauthAuth(optionTree);
	}
}
