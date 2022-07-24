package br.com.mind5.masterData.countryLegalSearch.model.action;

import java.util.List;

import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountrarchVisiMergeToSelect extends ActionVisitorTemplateMerge<CountrarchInfo, CountrarchInfo> {
	
	public CountrarchVisiMergeToSelect(DeciTreeOption<CountrarchInfo> option) {
		super(option, CountrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CountrarchInfo>> getVisitorClassHook() {
		return CountrarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CountrarchInfo> mergeHook(List<CountrarchInfo> baseInfos, List<CountrarchInfo> selectedInfos) {	
		return CountrarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
