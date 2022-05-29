package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.decisionTree.OtpRootGenerate;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.info.OtporeMerger;

final class VisiOtporeOtpGenerate extends ActionVisitorTemplateAction<OtporeInfo, OtpInfo> {
	
	public VisiOtporeOtpGenerate(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class, OtpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtpInfo>> getTreeClassHook() {
		return OtpRootGenerate.class;
	}
	
	
	
	@Override protected List<OtporeInfo> toBaseClassHook(List<OtporeInfo> baseInfos, List<OtpInfo> results) {	
		return OtporeMerger.mergeWithOtp(baseInfos, results);
	}
}
