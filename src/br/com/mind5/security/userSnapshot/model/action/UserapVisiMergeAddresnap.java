package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.AddresnapRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

public final class UserapVisiMergeAddresnap extends ActionVisitorTemplateMerge<UserapInfo, AddresnapInfo> {
	
	public UserapVisiMergeAddresnap(DeciTreeOption<UserapInfo> option) {
		super(option, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return AddresnapRootSearch.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<UserapInfo> baseInfos) {
		return AddresnapCopier.copyFromUserapKey(baseInfos);
	}	
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return UserapMerger.mergeWithAddresnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
