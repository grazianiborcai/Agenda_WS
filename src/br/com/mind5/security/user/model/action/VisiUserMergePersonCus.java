package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.business.personCustomer.model.decisionTree.RootPersonCusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergePersonCus extends ActionVisitorTemplateMergeV2<UserInfo, PersonCusInfo> {
	
	public VisiUserMergePersonCus(Connection conn, String schemaName) {
		super(conn, schemaName, PersonCusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonCusInfo>> getTreeClassHook() {
		return RootPersonCusSelect.class;
	}
	
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<PersonCusInfo> selectedInfos) {	
		return UserMerger.mergeWithPersonCus(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
