package br.com.mind5.masterData.country.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.action.StdCountryDaoSelect;
import br.com.mind5.masterData.country.model.checker.CountryCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCountrySelect extends DeciTreeTemplateReadV2<CountryInfo> {
	
	public RootCountrySelect(DeciTreeOption<CountryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountryInfo> buildCheckerHook(DeciTreeOption<CountryInfo> option) {
		List<ModelCheckerV1<CountryInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountryInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountryCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CountryInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryInfo> option) {
		List<ActionStdV2<CountryInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CountryInfo> select = new StdCountryDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
