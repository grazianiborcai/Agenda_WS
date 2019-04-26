package br.com.gda.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.info.MatextMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiMatextMergeUsername extends ActionVisitorTemplateMerge<MatextInfo, UsernameInfo> {
	
	public VisiMatextMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<MatextInfo> recordInfos) {
		return UsernameCopier.copyFromMatext(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatextInfo>> getMergerClassHook() {
		return MatextMerger.class;
	}
}
