package br.com.mind5.masterData.materialSubgroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.MatubupVisiDaoSelect;
import br.com.mind5.masterData.materialSubgroup.model.action.MatubupVisiMergeMatoup;
import br.com.mind5.masterData.materialSubgroup.model.checker.MatubupCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatubupRootSelect extends DeciTreeTemplateRead<MatubupInfo> {
	
	public MatubupRootSelect(DeciTreeOption<MatubupInfo> option) {
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
		
		ActionStd<MatubupInfo> select = new ActionStdCommom<MatubupInfo>(option, MatubupVisiDaoSelect.class);
		ActionLazy<MatubupInfo> mergeMatoup = new ActionLazyCommom<MatubupInfo>(option, MatubupVisiMergeMatoup.class);
		
		select.addPostAction(mergeMatoup);
		
		actions.add(select);
		return actions;
	}
}
