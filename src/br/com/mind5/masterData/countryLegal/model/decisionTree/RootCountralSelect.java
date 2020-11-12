package br.com.mind5.masterData.countryLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.action.LazyCountralMergeCountry;
import br.com.mind5.masterData.countryLegal.model.action.StdCountralMergeToSelect;
import br.com.mind5.masterData.countryLegal.model.checker.CountralCheckLangu;
import br.com.mind5.masterData.countryLegal.model.checker.CountralCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCountralSelect extends DeciTreeTemplateReadV2<CountralInfo> {
	
	public RootCountralSelect(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountralInfo> buildCheckerHook(DeciTreeOption<CountralInfo> option) {
		List<ModelCheckerV1<CountralInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountralInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountralCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CountralCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountralInfo>> buildActionsOnPassedHook(DeciTreeOption<CountralInfo> option) {
		List<ActionStdV1<CountralInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CountralInfo> select = new StdCountralMergeToSelect(option);
		ActionLazyV1<CountralInfo> mergeCountry = new LazyCountralMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
