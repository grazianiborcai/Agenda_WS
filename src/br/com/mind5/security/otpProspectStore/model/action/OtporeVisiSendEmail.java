package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.message.emailProspectStore.info.EmaproreCopier;
import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.message.emailProspectStore.model.decisionTree.EmaproreRootSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class OtporeVisiSendEmail extends ActionVisitorTemplateAction<OtporeInfo, EmaproreInfo> {
	
	public OtporeVisiSendEmail(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class, EmaproreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmaproreInfo>> getTreeClassHook() {
		return EmaproreRootSend.class;
	}
	
	
	
	@Override protected List<EmaproreInfo> toActionClassHook(List<OtporeInfo> recordInfos) {
		return EmaproreCopier.copyFromOtpore(recordInfos);
	}
	
	
	
	@Override protected List<OtporeInfo> toBaseClassHook(List<OtporeInfo> baseInfos, List<EmaproreInfo> results) {
		return baseInfos;
	}
}
