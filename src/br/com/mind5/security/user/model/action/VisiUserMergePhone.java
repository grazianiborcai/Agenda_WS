package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergePhone extends ActionVisitorTemplateMergeV2<UserInfo, PhoneInfo> {
	
	public VisiUserMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSearch.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<PhoneInfo> selectedInfos) {	
		return UserMerger.mergeWithPhone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
