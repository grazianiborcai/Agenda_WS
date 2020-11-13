package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergeAddress extends ActionVisitorTemplateMerge<UserInfo, AddressInfo> {
	
	public VisiUserMergeAddress(DeciTreeOption<UserInfo> option) {
		super(option, AddressInfo.class);
	} 
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<UserInfo> baseInfos) {
		return AddressCopier.copyFromUserKey(baseInfos);	
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return UserMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}	
}
