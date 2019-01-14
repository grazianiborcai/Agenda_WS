package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.RootPhoneSnapSelect;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserSnapMergePhoneSnap extends ActionVisitorTemplateMerge<UserSnapInfo, PhoneSnapInfo> {
	
	public VisiUserSnapMergePhoneSnap(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneSnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneSnapInfo>> getTreeClassHook() {
		return RootPhoneSnapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<UserSnapInfo>> getMergerClassHook() {
		return UserSnapMerger.class;
	}
}
