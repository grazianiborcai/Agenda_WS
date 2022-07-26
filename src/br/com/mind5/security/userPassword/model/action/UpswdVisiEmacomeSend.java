package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeCopier;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.decisionTree.EmacomeRootSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdVisiEmacomeSend extends ActionVisitorTemplateAction<UpswdInfo, EmacomeInfo> {
	
	public UpswdVisiEmacomeSend(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, EmacomeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmacomeInfo>> getTreeClassHook() {
		return EmacomeRootSend.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> toActionClassHook(List<UpswdInfo> recordInfos) {
		return EmacomeCopier.copyFromUpswd(recordInfos);
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<EmacomeInfo> results) {
		return baseInfos;
	}
}
