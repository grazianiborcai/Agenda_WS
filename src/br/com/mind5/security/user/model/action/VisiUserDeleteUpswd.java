package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdDelete;

final class VisiUserDeleteUpswd extends ActionVisitorTemplateActionV2<UserInfo, UpswdInfo> {
	
	public VisiUserDeleteUpswd(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UpswdInfo>> getTreeClassHook() {
		return RootUpswdDelete.class;
	}
	
	
	
	@Override protected List<UpswdInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return UpswdInfo.copyFrom(recordInfos);
	}
}
