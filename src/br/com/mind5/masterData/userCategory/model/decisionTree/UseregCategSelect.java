package br.com.mind5.masterData.userCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.action.StdUseregDaoSelect;
import br.com.mind5.masterData.userCategory.model.checker.UseregCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class UseregCategSelect extends DeciTreeTemplateRead<UseregInfo> {
	
	public UseregCategSelect(DeciTreeOption<UseregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UseregInfo> buildCheckerHook(DeciTreeOption<UseregInfo> option) {
		List<ModelChecker<UseregInfo>> queue = new ArrayList<>();		
		ModelChecker<UseregInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UseregCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UseregInfo>> buildActionsOnPassedHook(DeciTreeOption<UseregInfo> option) {
		List<ActionStd<UseregInfo>> actions = new ArrayList<>();
		
		ActionStd<UseregInfo> select = new StdUseregDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
