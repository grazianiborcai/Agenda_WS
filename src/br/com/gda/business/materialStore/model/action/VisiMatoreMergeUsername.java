package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.info.MatoreMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiMatoreMergeUsername extends ActionVisitorTemplateMerge<MatoreInfo, UsernameInfo> {
	
	public VisiMatoreMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<MatoreInfo> recordInfos) {
		return UsernameCopier.copyFromMatore(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatoreInfo>> getMergerClassHook() {
		return MatoreMerger.class;
	}
}
