package br.com.mind5.business.materialStock.model.action;

import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.info.MatockMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatockVisiMergeToSelect extends ActionVisitorTemplateMerge<MatockInfo, MatockInfo> {
	
	public MatockVisiMergeToSelect(DeciTreeOption<MatockInfo> option) {
		super(option, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatockInfo>> getVisitorClassHook() {
		return MatockVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatockInfo> mergeHook(List<MatockInfo> baseInfos, List<MatockInfo> selectedInfos) {	
		return MatockMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
