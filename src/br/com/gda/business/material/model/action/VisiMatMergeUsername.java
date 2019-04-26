package br.com.gda.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiMatMergeUsername extends ActionVisitorTemplateMerge<MatInfo, UsernameInfo> {
	
	public VisiMatMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<MatInfo> recordInfos) {
		return UsernameCopier.copyFromMat(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
