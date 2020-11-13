package br.com.mind5.masterData.materialSubgroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.LazyMatubupMergeMatoup;
import br.com.mind5.masterData.materialSubgroup.model.action.StdMatubupDaoSelect;
import br.com.mind5.masterData.materialSubgroup.model.checker.MatubupCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatubupSelect extends DeciTreeTemplateReadV1<MatubupInfo> {
	
	public RootMatubupSelect(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatubupInfo> buildCheckerHook(DeciTreeOption<MatubupInfo> option) {
		List<ModelCheckerV1<MatubupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatubupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatubupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatubupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatubupInfo> option) {
		List<ActionStdV2<MatubupInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatubupInfo> select = new StdMatubupDaoSelect(option);
		ActionLazy<MatubupInfo> mergeMatoup = new LazyMatubupMergeMatoup(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatoup);
		
		actions.add(select);
		return actions;
	}
}
