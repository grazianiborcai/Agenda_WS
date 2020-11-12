package br.com.mind5.masterData.countryLegalSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.masterData.countryLegalSearch.model.action.StdCountrarchMergeToSelect;
import br.com.mind5.masterData.countryLegalSearch.model.checker.CountrarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCountrarchSelect extends DeciTreeTemplateReadV2<CountrarchInfo> {
	
	public RootCountrarchSelect(DeciTreeOption<CountrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountrarchInfo> buildCheckerHook(DeciTreeOption<CountrarchInfo> option) {
		List<ModelCheckerV1<CountrarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountrarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountrarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountrarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CountrarchInfo> option) {
		List<ActionStdV1<CountrarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CountrarchInfo> select = new StdCountrarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
