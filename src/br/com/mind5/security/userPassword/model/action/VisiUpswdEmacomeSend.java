package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeCopier;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.decisionTree.RootEmacomeSend;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class VisiUpswdEmacomeSend extends ActionVisitorTemplateActionV2<UpswdInfo, EmacomeInfo> {
	
	public VisiUpswdEmacomeSend(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, EmacomeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmacomeInfo>> getTreeClassHook() {
		return RootEmacomeSend.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> toActionClassHook(List<UpswdInfo> recordInfos) {
		return EmacomeCopier.copyFromUpswd(recordInfos);
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<EmacomeInfo> results) {
		return baseInfos;
	}
}
