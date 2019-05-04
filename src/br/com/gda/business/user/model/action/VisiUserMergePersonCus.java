package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.decisionTree.RootPersonCusSelect;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserMergePersonCus extends ActionVisitorTemplateMerge_<UserInfo, PersonCusInfo> {
	
	public VisiUserMergePersonCus(Connection conn, String schemaName) {
		super(conn, schemaName, PersonCusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonCusInfo>> getTreeClassHook() {
		return RootPersonCusSelect.class;
	}
	
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<PersonCusInfo> selectedInfos) {	
		return UserMerger.mergeWithPersonCus(selectedInfos, recordInfos);
	}
}
