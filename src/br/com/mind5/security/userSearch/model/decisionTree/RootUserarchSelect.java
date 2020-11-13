package br.com.mind5.security.userSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.action.StdUserarchMergeToSelect;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckRead;

public final class RootUserarchSelect extends DeciTreeTemplateRead<UserarchInfo> {
	
	public RootUserarchSelect(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserarchInfo> buildCheckerHook(DeciTreeOption<UserarchInfo> option) {
		List<ModelChecker<UserarchInfo>> queue = new ArrayList<>();		
		ModelChecker<UserarchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserarchInfo>> buildActionsOnPassedHook(DeciTreeOption<UserarchInfo> option) {
		List<ActionStd<UserarchInfo>> actions = new ArrayList<>();
		
		ActionStd<UserarchInfo> select = new StdUserarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
