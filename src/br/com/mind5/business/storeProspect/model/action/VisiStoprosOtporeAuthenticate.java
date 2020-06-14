package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.decisionTree.RootOtporeAuthenticate;

final class VisiStoprosOtporeAuthenticate extends ActionVisitorTemplateActionV2<StoprosInfo, OtporeInfo> {
	
	public VisiStoprosOtporeAuthenticate(DeciTreeOption<StoprosInfo> option) {
		super(option, StoprosInfo.class, OtporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtporeInfo>> getTreeClassHook() {
		return RootOtporeAuthenticate.class;
	}
	
	
	
	@Override protected List<StoprosInfo> toBaseClassHook(List<StoprosInfo> baseInfos, List<OtporeInfo> results) {
		return baseInfos;
	}
}
