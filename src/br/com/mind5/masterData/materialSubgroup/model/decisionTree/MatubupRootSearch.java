package br.com.mind5.masterData.materialSubgroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.MatubupVisiRootSelect;
import br.com.mind5.masterData.materialSubgroup.model.action.MatubupVisiMergeMatubuparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatubupRootSearch extends DeciTreeTemplateRead<MatubupInfo> {
	
	public MatubupRootSearch(DeciTreeOption<MatubupInfo> option) {
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
		
		ActionStd<MatubupInfo> mergeMatubuparch = new ActionStdCommom<MatubupInfo>(option, MatubupVisiMergeMatubuparch.class);
		ActionLazy<MatubupInfo> select = new ActionLazyCommom<MatubupInfo>(option, MatubupVisiRootSelect.class);
		
		mergeMatubuparch.addPostAction(select);
		
		actions.add(mergeMatubuparch);
		return actions;
	}
}
