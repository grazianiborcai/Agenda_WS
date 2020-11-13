package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdDaoUpdate;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceHash;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceLength;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceSalt;
import br.com.mind5.security.userPassword.model.action.StdUpswdEnforceLChanged;

public final class NodeUpswdUpdateL2 extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public NodeUpswdUpdateL2(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> enforceLChanged = new StdUpswdEnforceLChanged(option);
		ActionLazy<UpswdInfo> enforceLength = new LazyUpswdEnforceLength(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> enforceSalt = new LazyUpswdEnforceSalt(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> enforceHash = new LazyUpswdEnforceHash(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> update = new LazyUpswdDaoUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLength);
		enforceLength.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);				
		enforceHash.addPostAction(update);

		actions.add(enforceLChanged);	
		return actions;
	}
}
