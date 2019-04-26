package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.business.user.info.UserCopier;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCusInsertUser extends ActionVisitorTemplateAction<CusInfo, UserInfo> {
	public VisiCusInsertUser(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<CusInfo> recordInfos) {
		List<UserInfo> results = new ArrayList<>();
		
		for (CusInfo eachRecord : recordInfos) {
			results.add(UserCopier.copyFromCus(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserInsert(option).toAction();
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<UserInfo> results) {
		return CusMerger.mergeWithUser(results, baseInfos);
	}
}
