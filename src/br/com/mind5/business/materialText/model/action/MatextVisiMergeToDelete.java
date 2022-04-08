package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextVisiMergeToDelete extends ActionVisitorTemplateMerge<MatextInfo, MatextInfo> {
	
	public MatextVisiMergeToDelete(DeciTreeOption<MatextInfo> option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatextInfo>> getVisitorClassHook() {
		return MatextVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {	
		return MatextMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
