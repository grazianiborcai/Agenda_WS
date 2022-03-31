package br.com.mind5.business.addressSnapshotSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnaparchVisiMergeToSelect extends ActionVisitorTemplateMerge<AddresnaparchInfo, AddresnaparchInfo> {
	
	public AddresnaparchVisiMergeToSelect(DeciTreeOption<AddresnaparchInfo> option) {
		super(option, AddresnaparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<AddresnaparchInfo>> getVisitorClassHook() {
		return AddresnaparchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<AddresnaparchInfo> mergeHook(List<AddresnaparchInfo> baseInfos, List<AddresnaparchInfo> selectedInfos) {	
		return AddresnaparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
