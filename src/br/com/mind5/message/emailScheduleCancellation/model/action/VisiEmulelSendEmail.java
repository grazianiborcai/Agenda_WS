package br.com.mind5.message.emailScheduleCancellation.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.RootEmailScheduleCancellation;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmulelSendEmail extends ActionVisitorTemplateActionV2<EmulelInfo, EmailInfo> {
	
	public VisiEmulelSendEmail(DeciTreeOption<EmulelInfo> option) {
		super(option, EmulelInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return RootEmailScheduleCancellation.class;
	}
	
	
	
	@Override protected List<EmulelInfo> toBaseClassHook(List<EmulelInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
