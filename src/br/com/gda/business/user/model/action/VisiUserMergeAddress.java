package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressCopier;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserMergeAddress extends ActionVisitorTemplateMerge<UserInfo, AddressInfo> {
	
	public VisiUserMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return AddressCopier.copyFromUserKey(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserInfo>> getMergerClassHook() {
		return UserMerger.class;
	}
}
