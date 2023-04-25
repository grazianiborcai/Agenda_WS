package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.UpswdVisiDaoUpdate;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceHash;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceLChanged;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceLength;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceSalt;

public final class UpswdNodeUpdateL2 extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public UpswdNodeUpdateL2(DeciTreeOption<UpswdInfo> option) {
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
		
		ActionStd <UpswdInfo> enforceLChanged = new ActionStdCommom <UpswdInfo>(option, UpswdVisiEnforceLChanged.class);
		ActionLazy<UpswdInfo> enforceLength   = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceLength.class);
		ActionLazy<UpswdInfo> enforceSalt     = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceSalt.class);
		ActionLazy<UpswdInfo> enforceHash     = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceHash.class);
		ActionLazy<UpswdInfo> update          = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiDaoUpdate.class);
		
		enforceLChanged.addPostAction(enforceLength);
		enforceLength.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);				
		enforceHash.addPostAction(update);

		actions.add(enforceLChanged);	
		return actions;
	}
}
