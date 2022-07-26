package br.com.mind5.message.emailPasswordChange.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.EmailRootPasswordChange;
import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmordeSendEmail extends ActionVisitorTemplateAction<EmordeInfo, EmailInfo> {
	
	public VisiEmordeSendEmail(DeciTreeOption<EmordeInfo> option) {
		super(option, EmordeInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return EmailRootPasswordChange.class;
	}
	
	
	
	@Override protected List<EmordeInfo> toBaseClassHook(List<EmordeInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
