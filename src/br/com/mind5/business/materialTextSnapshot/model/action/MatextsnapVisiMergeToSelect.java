package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextsnapVisiMergeToSelect extends ActionVisitorTemplateMerge<MatextsnapInfo, MatextsnapInfo> {
	
	public MatextsnapVisiMergeToSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option, MatextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatextsnapInfo>> getVisitorClassHook() {
		return MatextsnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextsnapInfo> toActionClassHook(List<MatextsnapInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<MatextsnapInfo> mergeHook(List<MatextsnapInfo> baseInfos, List<MatextsnapInfo> selectedInfos) {	
		return MatextsnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
