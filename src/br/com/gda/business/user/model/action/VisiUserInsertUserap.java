package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.RootUserapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserInsertUserap extends ActionVisitorTemplateAction<UserInfo, UserapInfo> {
	public VisiUserInsertUserap(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, UserapInfo.class);
	}
	
	
	
	@Override protected ActionStd<UserapInfo> getActionHook(DeciTreeOption<UserapInfo> option) {
		return new RootUserapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UserapInfo> results) {
		return UserMerger.mergeWithUserap(results, baseInfos);
	}
}
