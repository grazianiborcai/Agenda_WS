package br.com.mind5.message.emailScheduleConfirmation.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.EmailRootScheduleConfirmation;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmulonSendEmail extends ActionVisitorTemplateAction<EmulonInfo, EmailInfo> {
	
	public VisiEmulonSendEmail(DeciTreeOption<EmulonInfo> option) {
		super(option, EmulonInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return EmailRootScheduleConfirmation.class;
	}
	
	
	
	@Override protected List<EmulonInfo> toBaseClassHook(List<EmulonInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
