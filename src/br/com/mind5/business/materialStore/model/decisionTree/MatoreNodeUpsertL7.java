package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.MatoreVisiNodeSnapshot;
import br.com.mind5.business.materialStore.model.action.MatoreVisiRootSelect;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceLChanged;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeToUpdate;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoreNodeUpsertL7 extends DeciTreeTemplateWrite<MatoreInfo> {
	
	public MatoreNodeUpsertL7(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> mergeToUpdate = new ActionStdCommom<MatoreInfo>(option, MatoreVisiMergeToUpdate.class);
		ActionLazy<MatoreInfo> enforceLChanged = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceLChanged.class);
		ActionLazy<MatoreInfo> enforceLChangedBy = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeUsername.class);
		ActionLazy<MatoreInfo> snapshot = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiNodeSnapshot.class);
		ActionLazy<MatoreInfo> select = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiRootSelect.class);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(snapshot);
		snapshot.addPostAction(select);

		actions.add(mergeToUpdate);

		return actions;
	}
}
