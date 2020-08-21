package br.com.mind5.masterData.materialSubgroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.LazyMatubupRootSelect;
import br.com.mind5.masterData.materialSubgroup.model.action.StdMatubupMergeMatouparch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
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
	
	
	
	@Override protected List<ActionStdV1<MatubupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatubupInfo> option) {
		List<ActionStdV1<MatubupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatubupInfo> mergeMatouparch = new StdMatubupMergeMatouparch(option);
		ActionLazyV1<MatubupInfo> select = new LazyMatubupRootSelect(option.conn, option.schemaName);
		
		mergeMatouparch.addPostAction(select);
		
		actions.add(mergeMatouparch);
		return actions;
	}
}
