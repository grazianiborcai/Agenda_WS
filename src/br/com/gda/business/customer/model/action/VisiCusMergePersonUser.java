package br.com.gda.business.customer.model.action;

import java.sql.Connection;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.model.decisionTree.RootPersonUserSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusMergePersonUser extends ActionVisitorTemplateMerge<CusInfo, PersonUserInfo> {
	
	public VisiCusMergePersonUser(Connection conn, String schemaName) {
		super(conn, schemaName, PersonUserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonUserInfo>> getTreeClassHook() {
		return RootPersonUserSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CusInfo>> getMergerClassHook() {
		return CusMerger.class;
	}
}
