package br.com.mind5.message.emailWelcome.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailCopier;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.RootEmailWelcome;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmacomeSendEmail extends ActionVisitorTemplateActionV2<EmacomeInfo, EmailInfo> {
	
	public VisiEmacomeSendEmail(DeciTreeOption<EmacomeInfo> option) {
		super(option, EmacomeInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return RootEmailWelcome.class;
	}
	
	
	
	@Override protected List<EmailInfo> toActionClassHook(List<EmacomeInfo> recordInfos) {
		return EmailCopier.copyFromEmacome(recordInfos);
	}
	
	
	
	@Override protected List<EmacomeInfo> toBaseClassHook(List<EmacomeInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
