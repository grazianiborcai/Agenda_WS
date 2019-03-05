package br.com.gda.business.company.model.action;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.info.CompMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiCompMergeUsername extends ActionVisitorTemplateMerge<CompInfo, UsernameInfo> {
	
	public VisiCompMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CompInfo>> getMergerClassHook() {
		return CompMerger.class;
	}
}
