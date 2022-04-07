package br.com.mind5.business.materialMovementSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmarchVisiMergeToSelect extends ActionVisitorTemplateMerge<MatmarchInfo, MatmarchInfo> {
	
	public MatmarchVisiMergeToSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option, MatmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatmarchInfo>> getVisitorClassHook() {
		return MatmarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatmarchInfo> mergeHook(List<MatmarchInfo> baseInfos, List<MatmarchInfo> selectedInfos) {	
		return MatmarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
