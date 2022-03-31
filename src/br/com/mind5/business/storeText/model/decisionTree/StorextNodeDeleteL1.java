package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StorextVisiDaoDelete;
import br.com.mind5.business.storeText.model.action.StorextVisiDaoUpdate;
import br.com.mind5.business.storeText.model.action.StorextVisiEnforceLChanged;
import br.com.mind5.business.storeText.model.action.StorextVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StorextNodeDeleteL1 extends DeciTreeTemplateWrite<StorextInfo> {

	public StorextNodeDeleteL1(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelChecker<StorextInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextInfo> checker;
			
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<StorextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextInfo> enforceLChanged = new ActionStdCommom<StorextInfo>(option, StorextVisiEnforceLChanged.class);
		ActionLazy<StorextInfo> enforceLChangedBy = new ActionLazyCommom<StorextInfo>(option, StorextVisiMergeUsername.class);
		ActionLazy<StorextInfo> update = new ActionLazyCommom<StorextInfo>(option, StorextVisiDaoUpdate.class);
		ActionLazy<StorextInfo> delete = new ActionLazyCommom<StorextInfo>(option, StorextVisiDaoDelete.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
