package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.message.emailPasswordChange.model.decisionTree.RootEmordeSend;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class VisiUpswdEmordeSend extends ActionVisitorTemplateActionV2<UpswdInfo, EmordeInfo> {
	
	public VisiUpswdEmordeSend(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, EmordeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmordeInfo>> getTreeClassHook() {
		return RootEmordeSend.class;
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<EmordeInfo> results) {
		return baseInfos;
	}
}
