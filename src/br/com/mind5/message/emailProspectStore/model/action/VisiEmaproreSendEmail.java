package br.com.mind5.message.emailProspectStore.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.EmailRootProspectStore;
import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmaproreSendEmail extends ActionVisitorTemplateAction<EmaproreInfo, EmailInfo> {
	
	public VisiEmaproreSendEmail(DeciTreeOption<EmaproreInfo> option) {
		super(option, EmaproreInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return EmailRootProspectStore.class;
	}
	
	
	
	@Override protected List<EmaproreInfo> toBaseClassHook(List<EmaproreInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
