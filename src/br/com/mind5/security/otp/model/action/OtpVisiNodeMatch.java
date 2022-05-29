package br.com.mind5.security.otp.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.decisionTree.OtpNodeMatch;

public final class OtpVisiNodeMatch extends ActionVisitorTemplateAction<OtpInfo, OtpInfo> {

	public OtpVisiNodeMatch(DeciTreeOption<OtpInfo> option) {
		super(option, OtpInfo.class, OtpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtpInfo>> getTreeClassHook() {
		return OtpNodeMatch.class;
	}
	
	
	
	@Override protected List<OtpInfo> toBaseClassHook(List<OtpInfo> baseInfos, List<OtpInfo> results) {
		return results;
	}
}
