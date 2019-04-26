package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStolevateMergeUsername extends ActionVisitorTemplateMerge<StolevateInfo, UsernameInfo> {
	
	public VisiStolevateMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	protected List<UsernameInfo> toActionClassHook(List<StolevateInfo> recordInfos) {
		return UsernameCopier.copyFromStolevate(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StolevateInfo>> getMergerClassHook() {
		return StolevateMerger.class;
	}
}
