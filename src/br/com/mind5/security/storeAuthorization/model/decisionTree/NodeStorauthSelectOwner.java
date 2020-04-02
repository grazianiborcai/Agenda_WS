package br.com.mind5.security.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.action.LazyStorauthNodeSelectL2;
import br.com.mind5.security.storeAuthorization.model.action.StdStorauthEnforceOwnerKey;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckReadOwner;

public final class NodeStorauthSelectOwner extends DeciTreeWriteTemplate<StorauthInfo> {
	
	public NodeStorauthSelectOwner(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorauthInfo> buildDecisionCheckerHook(DeciTreeOption<StorauthInfo> option) {
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StorauthCheckReadOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStdV1<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorauthInfo> enforceOwnerKey = new StdStorauthEnforceOwnerKey(option);	
		ActionLazyV1<StorauthInfo> nodeSelectL2 = new LazyStorauthNodeSelectL2(option.conn, option.schemaName);
		
		enforceOwnerKey.addPostAction(nodeSelectL2);
			
		actions.add(enforceOwnerKey);		
		return actions;
	}
}
