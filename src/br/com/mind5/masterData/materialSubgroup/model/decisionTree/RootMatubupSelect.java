package br.com.mind5.masterData.materialSubgroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.LazyMatubupMergeMatoup;
import br.com.mind5.masterData.materialSubgroup.model.action.StdMatubupDaoSelect;
import br.com.mind5.masterData.materialSubgroup.model.checker.MatubupCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatubupSelect extends DeciTreeTemplateRead<MatubupInfo> {
	
	public RootMatubupSelect(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatubupInfo> buildCheckerHook(DeciTreeOption<MatubupInfo> option) {
		List<ModelChecker<MatubupInfo>> queue = new ArrayList<>();		
		ModelChecker<MatubupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatubupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatubupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatubupInfo> option) {
		List<ActionStd<MatubupInfo>> actions = new ArrayList<>();
		
		ActionStd<MatubupInfo> select = new StdMatubupDaoSelect(option);
		ActionLazy<MatubupInfo> mergeMatoup = new LazyMatubupMergeMatoup(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatoup);
		
		actions.add(select);
		return actions;
	}
}
