package br.com.mind5.authorization.scheduleAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.action.VisiSchedauthMergeSotarch;
import br.com.mind5.authorization.scheduleAuthorization.model.action.VisiSchedauthMergeUsername;
import br.com.mind5.authorization.scheduleAuthorization.model.action.VisiSchedauthObfuscateUser;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckAuthManager;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedauthNodeSearchL2 extends DeciTreeTemplateWrite<SchedauthInfo> {
	
	public SchedauthNodeSearchL2(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedauthInfo> buildCheckerHook(DeciTreeOption<SchedauthInfo> option) {
		List<ModelChecker<SchedauthInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedauthInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedauthCheckAuthManager(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedauthInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedauthInfo> option) {
		List<ActionStd<SchedauthInfo>> actions = new ArrayList<>();		

		ActionStd<SchedauthInfo> mergeUsername = new ActionStdCommom<SchedauthInfo>(option, VisiSchedauthMergeUsername.class);
		ActionLazy<SchedauthInfo> mergeSotarch = new ActionLazyCommom<SchedauthInfo>(option, VisiSchedauthMergeSotarch.class);
		ActionLazy<SchedauthInfo> obfuscateUser = new ActionLazyCommom<SchedauthInfo>(option, VisiSchedauthObfuscateUser.class);
		
		mergeUsername.addPostAction(mergeSotarch);
		mergeSotarch.addPostAction(obfuscateUser);
		
		actions.add(mergeUsername);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedauthInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedauthInfo> option) {
		List<ActionStd<SchedauthInfo>> actions = new ArrayList<>();		
	
		ActionStd<SchedauthInfo> nodeL3 = new SchedauthNodeSearchL3(option).toAction();	
		
		actions.add(nodeL3);		
		return actions;
	}
}
