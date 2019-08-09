package br.com.gda.security.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.checker.StorauthCheckIsCategOwner;

public final class NodeStorauthSelectL1 extends DeciTreeWriteTemplate<StorauthInfo> {
	
	public NodeStorauthSelectL1(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorauthInfo> buildDecisionCheckerHook(DeciTreeOption<StorauthInfo> option) {
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		
		checker = new StorauthCheckIsCategOwner();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> nodeSelectCategOwner = new NodeStorauthSelectCategOwner(option).toAction();			
		actions.add(nodeSelectCategOwner);		
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnFailedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> nodeSelectCategStore = new NodeStorauthSelectCategStore(option).toAction();			
		actions.add(nodeSelectCategStore);		
		
		return actions;
	}
}
