package br.com.mind5.message.emailProspectStore.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.RootEmailProspectStore;
import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmaproreSendEmail extends ActionVisitorTemplateActionV2<EmaproreInfo, EmailInfo> {
	
	public VisiEmaproreSendEmail(DeciTreeOption<EmaproreInfo> option) {
		super(option, EmaproreInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return RootEmailProspectStore.class;
	}
	
	
	
	@Override protected List<EmaproreInfo> toBaseClassHook(List<EmaproreInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
