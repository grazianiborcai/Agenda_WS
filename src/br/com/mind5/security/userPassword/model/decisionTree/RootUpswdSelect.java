package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceLength;
import br.com.mind5.security.userPassword.model.action.StdUpswdSelect;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckRead;

public final class RootUpswdSelect extends DeciTreeReadTemplate<UpswdInfo> {
	
	public RootUpswdSelect(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		
		checker = new UpswdCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> select = new StdUpswdSelect(option);
		ActionLazy<UpswdInfo> enforceLength = new LazyUpswdEnforceLength(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLength);
		
		actions.add(select);		
		return actions;
	}
}
