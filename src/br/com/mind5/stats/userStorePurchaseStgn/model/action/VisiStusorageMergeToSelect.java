package br.com.mind5.stats.userStorePurchaseStgn.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageInfo;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageMerger;

final class VisiStusorageMergeToSelect extends ActionVisitorTemplateMerge<StusorageInfo, StusorageInfo> {
	
	public VisiStusorageMergeToSelect(DeciTreeOption<StusorageInfo> option) {
		super(option, StusorageInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StusorageInfo>> getActionClassHook() {
		return StdStusorageDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorageInfo> mergeHook(List<StusorageInfo> baseInfos, List<StusorageInfo> selectedInfos) {	
		return StusorageMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
