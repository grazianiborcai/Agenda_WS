package br.com.gda.business.owner.model.action;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.model.decisionTree.RootPersonUserSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergePersonUser extends ActionVisitorTemplateMerge<OwnerInfo, PersonUserInfo> {
	
	public VisiOwnerMergePersonUser(Connection conn, String schemaName) {
		super(conn, schemaName, PersonUserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonUserInfo>> getTreeClassHook() {
		return RootPersonUserSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OwnerInfo>> getMergerClassHook() {
		return OwnerMerger.class;
	}
}
