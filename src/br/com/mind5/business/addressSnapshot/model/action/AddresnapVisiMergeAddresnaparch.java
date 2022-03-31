package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.business.addressSnapshotSearch.model.decisionTree.AddresnaparchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapVisiMergeAddresnaparch extends ActionVisitorTemplateMerge<AddresnapInfo, AddresnaparchInfo> {
	
	public AddresnapVisiMergeAddresnaparch(DeciTreeOption<AddresnapInfo> option) {
		super(option, AddresnaparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnaparchInfo>> getTreeClassHook() {
		return AddresnaparchRootSelect.class;
	}	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> baseInfos, List<AddresnaparchInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithAddresnaparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
