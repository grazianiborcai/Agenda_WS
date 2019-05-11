package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.decisionTree.RootAddressSnapSelect;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapMerger;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserSnapMergeAddressSnap extends ActionVisitorTemplateMerge_<UserSnapInfo, AddressSnapInfo> {
	
	public VisiUserSnapMergeAddressSnap(Connection conn, String schemaName) {
		super(conn, schemaName, AddressSnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressSnapInfo>> getTreeClassHook() {
		return RootAddressSnapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserSnapInfo>> getMergerClassHook() {
		return UserSnapMerger.class;
	}
}
