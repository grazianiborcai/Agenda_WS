package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.UselisVisiNodePerson;
import br.com.mind5.security.userList.model.action.UselisVisiMergeFimist;
import br.com.mind5.security.userList.model.action.UselisVisiMergeToSelect;
import br.com.mind5.security.userList.model.checker.UselisCheckLangu;
import br.com.mind5.security.userList.model.checker.UselisCheckOwner;
import br.com.mind5.security.userList.model.checker.UselisCheckRead;

public final class UselisRootSelect extends DeciTreeTemplateRead<UselisInfo> {
	
	public UselisRootSelect(DeciTreeOption<UselisInfo> option) {
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
		
		ActionStd<UselisInfo> select = new ActionStdCommom<UselisInfo>(option, UselisVisiMergeToSelect.class);
		ActionLazy<UselisInfo> person = new ActionLazyCommom<UselisInfo>(option, UselisVisiNodePerson.class);
		ActionLazy<UselisInfo> mergeFimist = new ActionLazyCommom<UselisInfo>(option, UselisVisiMergeFimist.class);
		
		select.addPostAction(person);
		person.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
