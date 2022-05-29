package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.decisionTree.OtpRootValidate;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.info.OtporeMerger;

final class VisiOtporeOtpValidate extends ActionVisitorTemplateAction<OtporeInfo, OtpInfo> {
	
	public VisiOtporeOtpValidate(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class, OtpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtpInfo>> getTreeClassHook() {
		return OtpRootValidate.class;
	}
	
	
	
	@Override protected List<OtporeInfo> toBaseClassHook(List<OtporeInfo> baseInfos, List<OtpInfo> results) {	
		return OtporeMerger.mergeWithOtp(baseInfos, results);
	}
}
