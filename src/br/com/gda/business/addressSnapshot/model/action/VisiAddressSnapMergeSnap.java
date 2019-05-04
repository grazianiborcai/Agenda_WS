package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.info.AddressSnapMerger;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.decisionTree.RootSnapInsert;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddressSnapMergeSnap extends ActionVisitorTemplateMerge_<AddressSnapInfo, SnapInfo> {
	
	public VisiAddressSnapMergeSnap(Connection conn, String schemaName) {
		super(conn, schemaName, SnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SnapInfo>> getTreeClassHook() {
		return RootSnapInsert.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<AddressSnapInfo>> getMergerClassHook() {
		return AddressSnapMerger.class;
	}
}
