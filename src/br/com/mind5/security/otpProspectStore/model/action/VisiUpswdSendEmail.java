package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeCopier;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.decisionTree.RootEmacomeSend;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

final class VisiUpswdSendEmail extends ActionVisitorTemplateActionV2<OtporeInfo, EmacomeInfo> {
	
	public VisiUpswdSendEmail(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class, EmacomeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmacomeInfo>> getTreeClassHook() {
		return RootEmacomeSend.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> toActionClassHook(List<OtporeInfo> recordInfos) {
		return EmacomeCopier.copyFromUpswd(recordInfos);
	}
	
	
	
	@Override protected List<OtporeInfo> toBaseClassHook(List<OtporeInfo> baseInfos, List<EmacomeInfo> results) {
		return baseInfos;
	}
}
