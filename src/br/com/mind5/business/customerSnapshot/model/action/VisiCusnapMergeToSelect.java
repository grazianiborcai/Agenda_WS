package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusnapMergeToSelect extends ActionVisitorTemplateMergeV2<CusnapInfo, CusnapInfo> {
	
	public VisiCusnapMergeToSelect(DeciTreeOption<CusnapInfo> option) {
		super(option, CusnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CusnapInfo>> getActionClassHook() {
		return StdCusnapDaoSelect.class;
	}
	
	
	
	@Override protected List<CusnapInfo> mergeHook(List<CusnapInfo> baseInfos, List<CusnapInfo> selectedInfos) {	
		return CusnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
