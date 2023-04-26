package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiEnforceLChanged;
import br.com.mind5.business.store.model.action.StoreVisiMergeToUpdate;
import br.com.mind5.business.store.model.action.StoreVisiMergeUsername;
import br.com.mind5.business.store.model.action.StoreVisiNodeSnapshot;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoreNodeUpdate extends DeciTreeTemplateWrite<StoreInfo> {
	
	public StoreNodeUpdate(DeciTreeOption<StoreInfo> option) {
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

		ActionStd <StoreInfo> mergeToUpdate     = new ActionStdCommom <StoreInfo>(option, StoreVisiMergeToUpdate.class);
		ActionLazy<StoreInfo> enforceLChanged   = new ActionLazyCommom<StoreInfo>(option, StoreVisiEnforceLChanged.class);
		ActionLazy<StoreInfo> enforceLChangedBy = new ActionLazyCommom<StoreInfo>(option, StoreVisiMergeUsername.class);
		ActionLazy<StoreInfo> snapshot          = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeSnapshot.class);	

		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
