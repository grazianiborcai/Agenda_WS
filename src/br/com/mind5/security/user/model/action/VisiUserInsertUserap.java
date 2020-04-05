package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.decisionTree.RootUserapInsert;

final class VisiUserInsertUserap extends ActionVisitorTemplateActionV1<UserInfo, UserapInfo> {
	public VisiUserInsertUserap(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, UserapInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<UserapInfo> getActionHook(DeciTreeOption<UserapInfo> option) {
		return new RootUserapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UserapInfo> results) {
		return UserMerger.mergeWithUserap(baseInfos, results);
	}
}
