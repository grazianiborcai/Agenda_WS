package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiOwnerMergeUsername extends ActionVisitorTemplateMerge<OwnerInfo, UsernameInfo> {
	
	public VisiOwnerMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return UsernameCopier.copyFromOwner(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OwnerInfo>> getMergerClassHook() {
		return OwnerMerger.class;
	}
}
