package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.action.StdCountrySelect;
import br.com.mind5.business.masterData.model.checker.CountryCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCountrySelect extends DeciTreeTemplateRead<CountryInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV1<CountryInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryInfo> option) {
		List<ActionStdV1<CountryInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CountryInfo> select = new StdCountrySelect(option);
		
		actions.add(select);
		return actions;
	}
}
