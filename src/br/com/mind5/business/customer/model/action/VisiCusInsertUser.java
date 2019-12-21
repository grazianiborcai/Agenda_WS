package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserInsertCus;

final class VisiCusInsertUser extends ActionVisitorTemplateAction<CusInfo, UserInfo> {
	public VisiCusInsertUser(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return UserCopier.copyFromCus(recordInfos);
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserInsertCus(option).toAction();
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<UserInfo> results) {
		return CusMerger.mergeWithUser(results, baseInfos);
	}
}
