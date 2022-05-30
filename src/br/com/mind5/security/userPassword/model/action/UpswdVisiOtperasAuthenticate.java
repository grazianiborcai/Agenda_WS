package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasCopier;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.decisionTree.OtperasRootAuthenticate;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdVisiOtperasAuthenticate extends ActionVisitorTemplateAction<UpswdInfo, OtperasInfo> {
	
	public UpswdVisiOtperasAuthenticate(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, OtperasInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtperasInfo>> getTreeClassHook() {
		return OtperasRootAuthenticate.class;
	}
	
	
	
	protected List<OtperasInfo> toActionClassHook(List<UpswdInfo> recordInfos) {
		return OtperasCopier.copyFromUpswd(recordInfos);	
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<OtperasInfo> results) {
		return baseInfos;
	}
}
