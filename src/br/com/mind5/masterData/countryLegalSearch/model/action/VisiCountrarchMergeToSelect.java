package br.com.mind5.masterData.countryLegalSearch.model.action;

import java.util.List;

import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountrarchMergeToSelect extends ActionVisitorTemplateMergeV2<CountrarchInfo, CountrarchInfo> {
	
	public VisiCountrarchMergeToSelect(DeciTreeOption<CountrarchInfo> option) {
		super(option, CountrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CountrarchInfo>> getActionClassHook() {
		return StdCountrarchDaoSelect.class;
	}
	
	
	
	@Override protected List<CountrarchInfo> mergeHook(List<CountrarchInfo> baseInfos, List<CountrarchInfo> selectedInfos) {	
		return CountrarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
