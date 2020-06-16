package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.message.emailProspectStore.info.EmaproreCopier;
import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.message.emailProspectStore.model.decisionTree.RootEmaproreSend;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

final class VisiOtperasSendEmail extends ActionVisitorTemplateActionV2<OtperasInfo, EmaproreInfo> {
	
	public VisiOtperasSendEmail(DeciTreeOption<OtperasInfo> option) {
		super(option, OtperasInfo.class, EmaproreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmaproreInfo>> getTreeClassHook() {
		return RootEmaproreSend.class;
	}
	
	
	
	@Override protected List<EmaproreInfo> toActionClassHook(List<OtperasInfo> recordInfos) {
		return EmaproreCopier.copyFromOtperas(recordInfos);
	}
	
	
	
	@Override protected List<OtperasInfo> toBaseClassHook(List<OtperasInfo> baseInfos, List<EmaproreInfo> results) {
		return baseInfos;
	}
}
