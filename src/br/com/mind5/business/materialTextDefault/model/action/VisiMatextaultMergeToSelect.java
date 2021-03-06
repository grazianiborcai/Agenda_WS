package br.com.mind5.business.materialTextDefault.model.action;

import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.info.MatextaultMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextaultMergeToSelect extends ActionVisitorTemplateMerge<MatextaultInfo, MatextaultInfo> {
	
	public VisiMatextaultMergeToSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option, MatextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextaultInfo>> getActionClassHook() {
		return StdMatextaultDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextaultInfo> toActionClassHook(List<MatextaultInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<MatextaultInfo> mergeHook(List<MatextaultInfo> baseInfos, List<MatextaultInfo> selectedInfos) {	
		return MatextaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
