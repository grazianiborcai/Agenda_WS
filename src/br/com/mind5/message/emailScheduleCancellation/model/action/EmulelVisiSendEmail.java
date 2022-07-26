package br.com.mind5.message.emailScheduleCancellation.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.EmailRootScheduleCancellation;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmulelVisiSendEmail extends ActionVisitorTemplateAction<EmulelInfo, EmailInfo> {
	
	public EmulelVisiSendEmail(DeciTreeOption<EmulelInfo> option) {
		super(option, EmulelInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return EmailRootScheduleCancellation.class;
	}
	
	
	
	@Override protected List<EmulelInfo> toBaseClassHook(List<EmulelInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
