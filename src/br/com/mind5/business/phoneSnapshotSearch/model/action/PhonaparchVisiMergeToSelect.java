package br.com.mind5.business.phoneSnapshotSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonaparchVisiMergeToSelect extends ActionVisitorTemplateMerge<PhonaparchInfo, PhonaparchInfo> {
	
	public PhonaparchVisiMergeToSelect(DeciTreeOption<PhonaparchInfo> option) {
		super(option, PhonaparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PhonaparchInfo>> getVisitorClassHook() {
		return PhonaparchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonaparchInfo> mergeHook(List<PhonaparchInfo> baseInfos, List<PhonaparchInfo> selectedInfos) {	
		return PhonaparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
