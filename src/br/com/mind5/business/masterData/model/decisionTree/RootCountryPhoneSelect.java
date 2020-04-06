package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdCountryPhoneSelect;
import br.com.mind5.business.masterData.model.checker.CountryPhoneCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCountryPhoneSelect extends DeciTreeTemplateRead<CountryPhoneInfo> {
	
	public RootCountryPhoneSelect(DeciTreeOption<CountryPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountryPhoneInfo> buildCheckerHook(DeciTreeOption<CountryPhoneInfo> option) {
		List<ModelCheckerV1<CountryPhoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountryPhoneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountryPhoneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountryPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryPhoneInfo> option) {
		List<ActionStdV1<CountryPhoneInfo>> actions = new ArrayList<>(); 
		
		ActionStdV1<CountryPhoneInfo> select = new StdCountryPhoneSelect(option);
		
		actions.add(select);
		return actions;
	}
}
