package br.com.mind5.business.addressSnapshotSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddresnaparchMergeToSelect extends ActionVisitorTemplateMerge<AddresnaparchInfo, AddresnaparchInfo> {
	
	public VisiAddresnaparchMergeToSelect(DeciTreeOption<AddresnaparchInfo> option) {
		super(option, AddresnaparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<AddresnaparchInfo>> getActionClassHook() {
		return StdAddresnaparchDaoSelect.class;
	}
	
	
	
	@Override protected List<AddresnaparchInfo> mergeHook(List<AddresnaparchInfo> baseInfos, List<AddresnaparchInfo> selectedInfos) {	
		return AddresnaparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
