package br.com.mind5.message.emailWelcome.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailCopier;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.EmailRootWelcome;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmacomeVisiSendEmail extends ActionVisitorTemplateAction<EmacomeInfo, EmailInfo> {
	
	public EmacomeVisiSendEmail(DeciTreeOption<EmacomeInfo> option) {
		super(option, EmacomeInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return EmailRootWelcome.class;
	}
	
	
	
	@Override protected List<EmailInfo> toActionClassHook(List<EmacomeInfo> recordInfos) {
		return EmailCopier.copyFromEmacome(recordInfos);
	}
	
	
	
	@Override protected List<EmacomeInfo> toBaseClassHook(List<EmacomeInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
