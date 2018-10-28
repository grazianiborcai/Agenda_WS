package br.com.gda.business.customer.model.action;

import java.sql.Connection;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.decisionTree.RootGenderSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusMergeGender extends ActionVisitorTemplateMerge<CusInfo, GenderInfo> {
	
	public VisiCusMergeGender(Connection conn, String schemaName) {
		super(conn, schemaName, GenderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GenderInfo>> getTreeClassHook() {
		return RootGenderSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CusInfo>> getMergerClassHook() {
		return CusMerger.class;
	}
}
