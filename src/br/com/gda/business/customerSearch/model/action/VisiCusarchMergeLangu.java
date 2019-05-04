package br.com.gda.business.customerSearch.model.action;

import java.sql.Connection;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.info.CusarchMerger;
import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.decisionTree.RootLanguSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusarchMergeLangu extends ActionVisitorTemplateMerge_<CusarchInfo, LanguInfo> {
	
	public VisiCusarchMergeLangu(Connection conn, String schemaName) {
		super(conn, schemaName, LanguInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<LanguInfo>> getTreeClassHook() {
		return RootLanguSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CusarchInfo>> getMergerClassHook() {
		return CusarchMerger.class;
	}
}
