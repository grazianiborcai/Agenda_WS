package br.com.mind5.security.userAuthentication.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.UpswdRootAuthUsername;

public final class UauthVisiAuthenticateUpswd extends ActionVisitorTemplateAction<UauthInfo, UpswdInfo> {
	
	public UauthVisiAuthenticateUpswd(DeciTreeOption<UauthInfo> option) {
		super(option, UauthInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UpswdInfo>> getTreeClassHook() {
		return UpswdRootAuthUsername.class;
	}
	
	
	
	@Override protected List<UauthInfo> toBaseClassHook(List<UauthInfo> baseInfos, List<UpswdInfo> results) {
		return baseInfos;
	}
}
