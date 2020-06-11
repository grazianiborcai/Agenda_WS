package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.decisionTree.RootOtpGenerate;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.info.UpswdMerger;

final class VisiOtporeOtpGenerate extends ActionVisitorTemplateActionV2<OtporeInfo, OtpInfo> {
	
	public VisiOtporeOtpGenerate(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class, OtpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtpInfo>> getTreeClassHook() {
		return RootOtpGenerate.class;
	}
	
	
	
	@Override protected List<OtporeInfo> toBaseClassHook(List<OtporeInfo> baseInfos, List<OtpInfo> results) {	
		return UpswdMerger.mergeWithOtp(baseInfos, results);
	}
}
