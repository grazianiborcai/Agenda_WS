package br.com.mind5.authorization.scheduleAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.action.LazySchedauthMergeSotarch;
import br.com.mind5.authorization.scheduleAuthorization.model.action.LazySchedauthObfuscateUser;
import br.com.mind5.authorization.scheduleAuthorization.model.action.StdSchedauthMergeUsername;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckAuthManager;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedauthSearchL2 extends DeciTreeTemplateWrite<SchedauthInfo> {
	
	public NodeSchedauthSearchL2(DeciTreeOption<SchedauthInfo> option) {
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

		ActionStd<SchedauthInfo> mergeUsername = new StdSchedauthMergeUsername(option);
		ActionLazy<SchedauthInfo> mergeSotarch = new LazySchedauthMergeSotarch(option.conn, option.schemaName);
		ActionLazy<SchedauthInfo> obfuscateUser = new LazySchedauthObfuscateUser(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(mergeSotarch);
		mergeSotarch.addPostAction(obfuscateUser);
		
		actions.add(mergeUsername);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedauthInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedauthInfo> option) {
		List<ActionStd<SchedauthInfo>> actions = new ArrayList<>();		
	
		ActionStd<SchedauthInfo> nodeL3 = new NodeSchedauthSearchL3(option).toAction();	
		
		actions.add(nodeL3);		
		return actions;
	}
}
