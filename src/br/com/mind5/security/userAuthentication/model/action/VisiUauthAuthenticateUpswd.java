package br.com.mind5.security.userAuthentication.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdAuthUsername;

final class VisiUauthAuthenticateUpswd extends ActionVisitorTemplateActionV2<UauthInfo, UpswdInfo> {
	
	public VisiUauthAuthenticateUpswd(DeciTreeOption<UauthInfo> option) {
		super(option, UauthInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UpswdInfo>> getTreeClassHook() {
		return RootUpswdAuthUsername.class;
	}
	
	
	
	@Override protected List<UauthInfo> toBaseClassHook(List<UauthInfo> baseInfos, List<UpswdInfo> results) {
		return baseInfos;
	}
}
