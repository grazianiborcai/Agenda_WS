package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceHash;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceLength;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforcePassword;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceSalt;
import br.com.mind5.security.userPassword.model.action.LazyUpswdUpdate;
import br.com.mind5.security.userPassword.model.action.StdUpswdEnforceLChanged;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckDummy;

public final class NodeUpswdUpdate extends DeciTreeReadTemplate<UpswdInfo> {
	
	public NodeUpswdUpdate(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;

		checker = new UpswdCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStdV1<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UpswdInfo> enforceLChanged = new StdUpswdEnforceLChanged(option);
		ActionLazyV1<UpswdInfo> enforceLength = new LazyUpswdEnforceLength(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> enforcePassword = new LazyUpswdEnforcePassword(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> enforceSalt = new LazyUpswdEnforceSalt(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> enforceHash = new LazyUpswdEnforceHash(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> update = new LazyUpswdUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLength);
		enforceLength.addPostAction(enforcePassword);
		enforcePassword.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);				
		enforceHash.addPostAction(update);

		actions.add(enforceLChanged);	
		return actions;
	}
}
