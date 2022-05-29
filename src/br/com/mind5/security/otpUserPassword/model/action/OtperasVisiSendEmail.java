package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.message.emailUserOtp.info.EmusotpCopier;
import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.message.emailUserOtp.model.decisionTree.RootEmusotpSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasVisiSendEmail extends ActionVisitorTemplateAction<OtperasInfo, EmusotpInfo> {
	
	public OtperasVisiSendEmail(DeciTreeOption<OtperasInfo> option) {
		super(option, OtperasInfo.class, EmusotpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmusotpInfo>> getTreeClassHook() {
		return RootEmusotpSend.class;
	}
	
	
	
	@Override protected List<EmusotpInfo> toActionClassHook(List<OtperasInfo> recordInfos) {
		return EmusotpCopier.copyFromOtperas(recordInfos);
	}
	
	
	
	@Override protected List<OtperasInfo> toBaseClassHook(List<OtperasInfo> baseInfos, List<EmusotpInfo> results) {
		return baseInfos;
	}
}
