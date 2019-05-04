package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;

final class VisiUserMergeToSelect extends ActionVisitorTemplateMerge_<UserInfo, UserInfo> {
	
	public VisiUserMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UserInfo>> getActionClassHook() {
		return StdUserSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<UserInfo> selectedInfos) {	
		return UserMerger.mergeToSelect(selectedInfos, recordInfos);
	}
}
