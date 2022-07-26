package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.message.emailPasswordChange.model.decisionTree.EmordeRootSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdVisiEmordeSend extends ActionVisitorTemplateAction<UpswdInfo, EmordeInfo> {
	
	public UpswdVisiEmordeSend(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, EmordeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmordeInfo>> getTreeClassHook() {
		return EmordeRootSend.class;
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<EmordeInfo> results) {
		return baseInfos;
	}
}
