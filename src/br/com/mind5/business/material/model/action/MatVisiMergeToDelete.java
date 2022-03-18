package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiMergeToDelete extends ActionVisitorTemplateMerge<MatInfo, MatInfo> {
	
	public MatVisiMergeToDelete(DeciTreeOption<MatInfo> option) {
		super(option, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatInfo>> getVisitorClassHook() {
		return MatVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {	
		return MatMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
