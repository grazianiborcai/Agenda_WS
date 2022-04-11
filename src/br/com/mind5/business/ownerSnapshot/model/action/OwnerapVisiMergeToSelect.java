package br.com.mind5.business.ownerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerapVisiMergeToSelect extends ActionVisitorTemplateMerge<OwnerapInfo, OwnerapInfo> {
	
	public OwnerapVisiMergeToSelect(DeciTreeOption<OwnerapInfo> option) {
		super(option, OwnerapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OwnerapInfo>> getVisitorClassHook() {
		return OwnerapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> baseInfos, List<OwnerapInfo> selectedInfos) {	
		return OwnerapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
