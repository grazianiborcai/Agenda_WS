package br.com.gda.security.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.action.LazyStorauthNodeSelectL2;
import br.com.gda.security.storeAuthorization.model.action.StdStorauthEnforceCategOwnerKey;
import br.com.gda.security.storeAuthorization.model.checker.StorauthCheckCategOwner;

public final class NodeStorauthSelectCategOwner extends DeciTreeWriteTemplate<StorauthInfo> {
	
	public NodeStorauthSelectCategOwner(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorauthInfo> buildDecisionCheckerHook(DeciTreeOption<StorauthInfo> option) {
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		
		checker = new StorauthCheckCategOwner();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> enforceCategOwnerKey = new StdStorauthEnforceCategOwnerKey(option);	
		ActionLazy<StorauthInfo> nodeSelectL2 = new LazyStorauthNodeSelectL2(option.conn, option.schemaName);
		
		enforceCategOwnerKey.addPostAction(nodeSelectL2);
			
		actions.add(enforceCategOwnerKey);		
		return actions;
	}
}
