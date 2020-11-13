package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.LazyUselisNodePerson;
import br.com.mind5.security.userList.model.action.StdUselisMergeToSelect;
import br.com.mind5.security.userList.model.checker.UselisCheckLangu;
import br.com.mind5.security.userList.model.checker.UselisCheckOwner;
import br.com.mind5.security.userList.model.checker.UselisCheckRead;

public final class RootUselisSelect extends DeciTreeTemplateRead<UselisInfo> {
	
	public RootUselisSelect(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UselisInfo> buildCheckerHook(DeciTreeOption<UselisInfo> option) {
		List<ModelChecker<UselisInfo>> queue = new ArrayList<>();		
		ModelChecker<UselisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UselisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UselisCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UselisCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStd<UselisInfo>> actions = new ArrayList<>();
		
		ActionStd<UselisInfo> select = new StdUselisMergeToSelect(option);
		ActionLazy<UselisInfo> person = new LazyUselisNodePerson(option.conn, option.schemaName);
		
		select.addPostAction(person);
		
		actions.add(select);
		return actions;
	}
}
