package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdDaoUpdate;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceHash;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceLength;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforcePassword;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceSalt;
import br.com.mind5.security.userPassword.model.action.StdUpswdEnforceLChanged;

public final class NodeUpswdUpdate extends DeciTreeTemplateWriteV2<UpswdInfo> {
	
	public NodeUpswdUpdate(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UpswdInfo> buildCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelCheckerV1<UpswdInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UpswdInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStdV1<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UpswdInfo> enforceLChanged = new StdUpswdEnforceLChanged(option);
		ActionLazyV1<UpswdInfo> enforceLength = new LazyUpswdEnforceLength(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> enforcePassword = new LazyUpswdEnforcePassword(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> enforceSalt = new LazyUpswdEnforceSalt(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> enforceHash = new LazyUpswdEnforceHash(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> update = new LazyUpswdDaoUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLength);
		enforceLength.addPostAction(enforcePassword);
		enforcePassword.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);				
		enforceHash.addPostAction(update);

		actions.add(enforceLChanged);	
		return actions;
	}
}
