package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiEnforceLChanged;
import br.com.mind5.business.store.model.action.StoreVisiMergeUsername;
import br.com.mind5.business.store.model.action.StoreVisiNodeSnapshot;
import br.com.mind5.business.store.model.action.StoreVisiNodeUpsertStorext;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoreNodeUpdateL2 extends DeciTreeTemplateWrite<StoreInfo> {
	
	public StoreNodeUpdateL2(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd<StoreInfo> enforceLChanged = new  ActionStdCommom<StoreInfo>(option, StoreVisiEnforceLChanged.class);
		ActionLazy<StoreInfo> enforceLChangedBy = new  ActionLazyCommom<StoreInfo>(option, StoreVisiMergeUsername.class);
		ActionLazy<StoreInfo> upsertStorext = new  ActionLazyCommom<StoreInfo>(option, StoreVisiNodeUpsertStorext.class);
		ActionLazy<StoreInfo> snapshot = new  ActionLazyCommom<StoreInfo>(option, StoreVisiNodeSnapshot.class);	
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(upsertStorext);
		upsertStorext.addPostAction(snapshot);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
