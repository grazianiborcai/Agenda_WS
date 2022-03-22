package br.com.mind5.business.addressDefault.model.action;

import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.info.AddaultMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddaultVisiMergeToSelect extends ActionVisitorTemplateMerge<AddaultInfo, AddaultInfo> {
	
	public AddaultVisiMergeToSelect(DeciTreeOption<AddaultInfo> option) {
		super(option, AddaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<AddaultInfo>> getVisitorClassHook() {
		return AddaultVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<AddaultInfo> mergeHook(List<AddaultInfo> baseInfos, List<AddaultInfo> selectedInfos) {	
		return AddaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
