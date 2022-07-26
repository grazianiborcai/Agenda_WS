package br.com.mind5.message.emailUserOtp.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.EmailRootUserOtp;
import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmusotpSendEmail extends ActionVisitorTemplateAction<EmusotpInfo, EmailInfo> {
	
	public VisiEmusotpSendEmail(DeciTreeOption<EmusotpInfo> option) {
		super(option, EmusotpInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmailInfo>> getTreeClassHook() {
		return EmailRootUserOtp.class;
	}
	
	
	
	@Override protected List<EmusotpInfo> toBaseClassHook(List<EmusotpInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
