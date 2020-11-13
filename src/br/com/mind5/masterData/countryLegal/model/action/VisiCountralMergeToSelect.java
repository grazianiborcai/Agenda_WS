package br.com.mind5.masterData.countryLegal.model.action;

import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.info.CountralMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountralMergeToSelect extends ActionVisitorTemplateMerge<CountralInfo, CountralInfo> {
	
	public VisiCountralMergeToSelect(DeciTreeOption<CountralInfo> option) {
		super(option, CountralInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CountralInfo>> getActionClassHook() {
		return StdCountralDaoSelect.class;
	}
	
	
	
	@Override protected List<CountralInfo> mergeHook(List<CountralInfo> baseInfos, List<CountralInfo> selectedInfos) {	
		return CountralMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
