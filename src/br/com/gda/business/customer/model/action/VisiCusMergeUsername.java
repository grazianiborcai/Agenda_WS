package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.model.action.obsolete.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiCusMergeUsername extends ActionVisitorTemplateMerge_<CusInfo, UsernameInfo> {
	
	public VisiCusMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return UsernameCopier.copyFromCus(recordInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return CusMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
}
