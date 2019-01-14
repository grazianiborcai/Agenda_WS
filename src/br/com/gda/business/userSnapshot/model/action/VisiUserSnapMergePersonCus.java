package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.decisionTree.RootPersonCusSelect;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserSnapMergePersonCus extends ActionVisitorTemplateMerge<UserSnapInfo, PersonCusInfo> {
	
	public VisiUserSnapMergePersonCus(Connection conn, String schemaName) {
		super(conn, schemaName, PersonCusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonCusInfo>> getTreeClassHook() {
		return RootPersonCusSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<UserSnapInfo>> getMergerClassHook() {
		return UserSnapMerger.class;
	}
}
