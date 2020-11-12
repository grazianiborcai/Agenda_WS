package br.com.mind5.masterData.countryLegal.model.action;

import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.info.CountralMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountralMergeToSelect extends ActionVisitorTemplateMergeV2<CountralInfo, CountralInfo> {
	
	public VisiCountralMergeToSelect(DeciTreeOption<CountralInfo> option) {
		super(option, CountralInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CountralInfo>> getActionClassHook() {
		return StdCountralDaoSelect.class;
	}
	
	
	
	@Override protected List<CountralInfo> mergeHook(List<CountralInfo> baseInfos, List<CountralInfo> selectedInfos) {	
		return CountralMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
