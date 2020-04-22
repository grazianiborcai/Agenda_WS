package br.com.mind5.business.materialTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextarchMergeToSelect extends ActionVisitorTemplateMergeV2<MatextarchInfo, MatextarchInfo> {
	
	public VisiMatextarchMergeToSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatextarchInfo>> getActionClassHook() {
		return StdMatextarchDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextarchInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<MatextarchInfo> mergeHook(List<MatextarchInfo> baseInfos, List<MatextarchInfo> selectedInfos) {	
		return MatextarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
