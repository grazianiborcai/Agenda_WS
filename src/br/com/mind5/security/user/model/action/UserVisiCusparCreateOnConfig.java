package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootCreateOnConfig;
import br.com.mind5.security.user.info.UserInfo;

public final class UserVisiCusparCreateOnConfig extends ActionVisitorTemplateAction<UserInfo, CusparInfo> {
	
	public UserVisiCusparCreateOnConfig(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootCreateOnConfig.class;
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<CusparInfo> results) {
		return baseInfos;
	}
}
