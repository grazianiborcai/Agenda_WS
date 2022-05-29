package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootInsertCus;

public final class CusVisiUserInsert extends ActionVisitorTemplateAction<CusInfo, UserInfo> {
	public CusVisiUserInsert(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootInsertCus.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return UserCopier.copyFromCus(recordInfos);
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<UserInfo> results) {
		return CusMerger.mergeWithUser(baseInfos, results);
	}
}
