package br.com.mind5.business.materialTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextarchMergeToSelect extends ActionVisitorTemplateMerge<MatextarchInfo, MatextarchInfo> {
	
	public VisiMatextarchMergeToSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextarchInfo>> getActionClassHook() {
		return StdMatextarchDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextarchInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<MatextarchInfo> mergeHook(List<MatextarchInfo> baseInfos, List<MatextarchInfo> selectedInfos) {	
		return MatextarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
