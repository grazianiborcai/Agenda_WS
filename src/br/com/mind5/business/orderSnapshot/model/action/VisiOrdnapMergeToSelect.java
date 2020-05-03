package br.com.mind5.business.orderSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdnapMergeToSelect extends ActionVisitorTemplateMergeV2<OrdnapInfo, OrdnapInfo> {
	
	public VisiOrdnapMergeToSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option, OrdnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrdnapInfo>> getActionClassHook() {
		return StdOrdnapDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> baseInfos, List<OrdnapInfo> selectedInfos) {	
		return OrdnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
