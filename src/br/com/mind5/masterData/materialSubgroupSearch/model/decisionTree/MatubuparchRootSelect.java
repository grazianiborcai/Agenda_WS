package br.com.mind5.masterData.materialSubgroupSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.masterData.materialSubgroupSearch.model.action.MatubuparchVisiDaoSelect;
import br.com.mind5.masterData.materialSubgroupSearch.model.checker.MatubuparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatubuparchRootSelect extends DeciTreeTemplateRead<MatubuparchInfo> {
	
	public MatubuparchRootSelect(DeciTreeOption<MatubuparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatubuparchInfo> buildCheckerHook(DeciTreeOption<MatubuparchInfo> option) {
		List<ModelChecker<MatubuparchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatubuparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatubuparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatubuparchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatubuparchInfo> option) {
		List<ActionStd<MatubuparchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatubuparchInfo> select = new ActionStdCommom<MatubuparchInfo>(option, MatubuparchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
