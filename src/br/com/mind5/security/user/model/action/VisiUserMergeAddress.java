package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergeAddress extends ActionVisitorTemplateMergeV2<UserInfo, AddressInfo> {
	
	public VisiUserMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return AddressCopier.copyFromUserKey(recordInfos);	
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<AddressInfo> selectedInfos) {	
		return UserMerger.mergeWithAddress(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}	
}
