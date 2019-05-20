package br.com.gda.business.userSnapshot_.model.action;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.decisionTree.RootAddresnapSelect;
import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.business.userSnapshot_.info.UserSnapMerger;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserSnapMergeAddressSnap extends ActionVisitorTemplateMerge_<UserSnapInfo, AddresnapInfo> {
	
	public VisiUserSnapMergeAddressSnap(Connection conn, String schemaName) {
		super(conn, schemaName, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return RootAddresnapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserSnapInfo>> getMergerClassHook() {
		return UserSnapMerger.class;
	}
}
