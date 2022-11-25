package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiMergeToUpdate extends ActionVisitorTemplateMerge<MatoupowInfo, MatoupowInfo> {
	
	public MatoupowVisiMergeToUpdate(DeciTreeOption<MatoupowInfo> option) {
		super(option, MatoupowInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatoupowInfo>> getVisitorClassHook() {
		return MatoupowVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatoupowInfo> mergeHook(List<MatoupowInfo> baseInfos, List<MatoupowInfo> selectedInfos) {	
		return MatoupowMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
