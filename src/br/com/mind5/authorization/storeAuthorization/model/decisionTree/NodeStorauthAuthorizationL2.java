package br.com.mind5.authorization.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.action.StdStorauthSuccess;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthCustomer;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeStorauthAuthorizationL2 extends DeciTreeTemplateWrite<StorauthInfo> {
	
	public NodeStorauthAuthorizationL2(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorauthInfo> buildCheckerHook(DeciTreeOption<StorauthInfo> option) {
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StorauthCheckAuthCustomer(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> success = new StdStorauthSuccess(option);			
		actions.add(success);		
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnFailedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> nodeL3 = new NodeStorauthAuthorizationL3(option).toAction();
			
		actions.add(nodeL3);		
		return actions;
	}
}
