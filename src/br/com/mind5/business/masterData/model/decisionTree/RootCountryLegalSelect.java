package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.model.action.LazyCountryLegalMergeCountry;
import br.com.mind5.business.masterData.model.action.StdCountryLegalSelect;
import br.com.mind5.business.masterData.model.checker.CountryLegalCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCountryLegalSelect extends DeciTreeTemplateRead<CountryLegalInfo> {
	
	public RootCountryLegalSelect(DeciTreeOption<CountryLegalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountryLegalInfo> buildCheckerHook(DeciTreeOption<CountryLegalInfo> option) {
		List<ModelCheckerV1<CountryLegalInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountryLegalInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountryLegalCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountryLegalInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryLegalInfo> option) {
		List<ActionStdV1<CountryLegalInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CountryLegalInfo> select = new StdCountryLegalSelect(option);
		ActionLazyV1<CountryLegalInfo> mergeCountry = new LazyCountryLegalMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
