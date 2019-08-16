package br.com.gda.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.userList.model.action.LazyUselisMergePersolis;
import br.com.gda.security.userList.model.action.StdUserMergeToSelect;
import br.com.gda.security.userList.model.checker.UselisCheckLangu;
import br.com.gda.security.userList.model.checker.UselisCheckOwner;
import br.com.gda.security.userList.model.checker.UselisCheckRead;

public final class RootUselisSelect extends DeciTreeReadTemplate<UselisInfo> {
	
	public RootUselisSelect(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UselisInfo> buildDecisionCheckerHook(DeciTreeOption<UselisInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<UselisInfo>> queue = new ArrayList<>();		
		ModelChecker<UselisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new UselisCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UselisCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UselisCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStd<UselisInfo>> actions = new ArrayList<>();
		
		ActionStd<UselisInfo> select = new StdUserMergeToSelect(option);
		ActionLazy<UselisInfo> mergePerson = new LazyUselisMergePersolis(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		
		actions.add(select);
		return actions;
	}
}
