package br.com.mind5.business.ownerSearch.model.action;

import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.info.OwnarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnarchVisiMergeToSelect extends ActionVisitorTemplateMerge<OwnarchInfo, OwnarchInfo> {
	
	public OwnarchVisiMergeToSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option, OwnarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OwnarchInfo>> getVisitorClassHook() {
		return OwnarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnarchInfo> mergeHook(List<OwnarchInfo> baseInfos, List<OwnarchInfo> selectedInfos) {	
		return OwnarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
