package br.com.mind5.masterData.materialSubgroupSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.masterData.materialSubgroupSearch.model.action.StdMatubuparchDaoSelect;
import br.com.mind5.masterData.materialSubgroupSearch.model.checker.MatubuparchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatubuparchSelect extends DeciTreeTemplateReadV1<MatubuparchInfo> {
	
	public RootMatubuparchSelect(DeciTreeOption<MatubuparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatubuparchInfo> buildCheckerHook(DeciTreeOption<MatubuparchInfo> option) {
		List<ModelCheckerV1<MatubuparchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatubuparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatubuparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatubuparchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatubuparchInfo> option) {
		List<ActionStdV2<MatubuparchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatubuparchInfo> select = new StdMatubuparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
