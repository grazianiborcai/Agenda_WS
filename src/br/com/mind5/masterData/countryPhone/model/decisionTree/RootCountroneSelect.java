package br.com.mind5.masterData.countryPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.masterData.countryPhone.model.action.StdCountroneDaoSelect;
import br.com.mind5.masterData.countryPhone.model.checker.CountroneCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCountroneSelect extends DeciTreeTemplateReadV2<CountroneInfo> {
	
	public RootCountroneSelect(DeciTreeOption<CountroneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountroneInfo> buildCheckerHook(DeciTreeOption<CountroneInfo> option) {
		List<ModelCheckerV1<CountroneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountroneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountroneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountroneInfo>> buildActionsOnPassedHook(DeciTreeOption<CountroneInfo> option) {
		List<ActionStdV1<CountroneInfo>> actions = new ArrayList<>(); 
		
		ActionStdV1<CountroneInfo> select = new StdCountroneDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
