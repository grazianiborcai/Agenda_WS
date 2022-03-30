package br.com.mind5.business.orderHistoryDecorated.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.business.orderHistoryDecorated.model.action.OrdorycoVisiMergeOrdorySearchAuth;
import br.com.mind5.business.orderHistoryDecorated.model.action.OrdorycoVisiMergeStusory;
import br.com.mind5.business.orderHistoryDecorated.model.action.OrdorycoVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdorycoRootSearchAuth extends DeciTreeTemplateRead<OrdorycoInfo> {
	
	public OrdorycoRootSearchAuth(DeciTreeOption<OrdorycoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdorycoInfo> buildCheckerHook(DeciTreeOption<OrdorycoInfo> option) {
		List<ModelChecker<OrdorycoInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdorycoInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdorycoInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdorycoInfo> option) {
		List<ActionStd<OrdorycoInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdorycoInfo> mergeUsername = new ActionStdCommom<OrdorycoInfo>(option, OrdorycoVisiMergeUsername.class);
		ActionLazy<OrdorycoInfo> mergeOrdory = new ActionLazyCommom<OrdorycoInfo>(option, OrdorycoVisiMergeOrdorySearchAuth.class);
		ActionLazy<OrdorycoInfo> mergeStusory = new ActionLazyCommom<OrdorycoInfo>(option, OrdorycoVisiMergeStusory.class);
		
		mergeUsername.addPostAction(mergeOrdory);
		mergeOrdory.addPostAction(mergeStusory);
		
		actions.add(mergeUsername);			
		return actions;
	}
}
