package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextsnapMergeToSelect extends ActionVisitorTemplateMergeV2<MatextsnapInfo, MatextsnapInfo> {
	
	public VisiMatextsnapMergeToSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option, MatextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatextsnapInfo>> getActionClassHook() {
		return StdMatextsnapDaoSelect.class;
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
