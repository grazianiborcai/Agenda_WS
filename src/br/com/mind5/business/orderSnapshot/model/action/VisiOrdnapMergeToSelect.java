package br.com.mind5.business.orderSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdnapMergeToSelect extends ActionVisitorTemplateMerge<OrdnapInfo, OrdnapInfo> {
	
	public VisiOrdnapMergeToSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option, OrdnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdnapInfo>> getActionClassHook() {
		return StdOrdnapDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> baseInfos, List<OrdnapInfo> selectedInfos) {	
		return OrdnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
