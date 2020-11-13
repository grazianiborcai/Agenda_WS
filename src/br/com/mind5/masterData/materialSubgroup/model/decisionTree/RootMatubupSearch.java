package br.com.mind5.masterData.materialSubgroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.LazyMatubupRootSelect;
import br.com.mind5.masterData.materialSubgroup.model.action.StdMatubupMergeMatubuparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatubupSearch extends DeciTreeTemplateRead<MatubupInfo> {
	
	public RootMatubupSearch(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatubupInfo> buildCheckerHook(DeciTreeOption<MatubupInfo> option) {
		List<ModelChecker<MatubupInfo>> queue = new ArrayList<>();		
		ModelChecker<MatubupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatubupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatubupInfo> option) {
		List<ActionStd<MatubupInfo>> actions = new ArrayList<>();
		
		ActionStd<MatubupInfo> mergeMatubuparch = new StdMatubupMergeMatubuparch(option);
		ActionLazy<MatubupInfo> select = new LazyMatubupRootSelect(option.conn, option.schemaName);
		
		mergeMatubuparch.addPostAction(select);
		
		actions.add(mergeMatubuparch);
		return actions;
	}
}
