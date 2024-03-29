package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.business.storeList.info.StolisCopier;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapVisiMergeStolis extends ActionVisitorTemplateMerge<AddresnapInfo, StolisInfo> {
	
	public AddresnapVisiMergeStolis(DeciTreeOption<AddresnapInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSelect.class;
	}

	
	
	protected List<StolisInfo> toActionClassHook(List<AddresnapInfo> baseInfos) {
		return StolisCopier.copyFromAddresnap(baseInfos);	
	}	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
