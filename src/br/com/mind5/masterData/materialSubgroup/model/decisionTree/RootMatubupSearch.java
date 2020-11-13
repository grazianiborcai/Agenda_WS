package br.com.mind5.masterData.materialSubgroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.LazyMatubupRootSelect;
import br.com.mind5.masterData.materialSubgroup.model.action.StdMatubupMergeMatubuparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatubupSearch extends DeciTreeTemplateReadV1<MatubupInfo> {
	
	public RootMatubupSearch(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatubupInfo> buildCheckerHook(DeciTreeOption<MatubupInfo> option) {
		List<ModelCheckerV1<MatubupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatubupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatubupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatubupInfo> option) {
		List<ActionStdV2<MatubupInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatubupInfo> mergeMatubuparch = new StdMatubupMergeMatubuparch(option);
		ActionLazy<MatubupInfo> select = new LazyMatubupRootSelect(option.conn, option.schemaName);
		
		mergeMatubuparch.addPostAction(select);
		
		actions.add(mergeMatubuparch);
		return actions;
	}
}
