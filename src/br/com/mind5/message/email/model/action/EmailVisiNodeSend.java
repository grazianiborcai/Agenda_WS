package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.EmailNodeSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmailVisiNodeSend extends ActionVisitorTemplateAction<EmailInfo, EmailInfo> {

	public EmailVisiNodeSend(DeciTreeOption<EmailInfo> option) {
		super(option, EmailInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return EmailNodeSend.class;
	}
	
	
	
	@Override protected List<EmailInfo> toBaseClassHook(List<EmailInfo> baseInfos, List<EmailInfo> results) {
		return results;
	}
}
