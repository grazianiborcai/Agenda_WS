package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.decisionTree.RootOtpGenerate;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasMerger;

final class VisiOtperasOtpGenerate extends ActionVisitorTemplateActionV2<OtperasInfo, OtpInfo> {
	
	public VisiOtperasOtpGenerate(DeciTreeOption<OtperasInfo> option) {
		super(option, OtperasInfo.class, OtpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtpInfo>> getTreeClassHook() {
		return RootOtpGenerate.class;
	}
	
	
	
	@Override protected List<OtperasInfo> toBaseClassHook(List<OtperasInfo> baseInfos, List<OtpInfo> results) {	
		return OtperasMerger.mergeWithOtp(baseInfos, results);
	}
}
