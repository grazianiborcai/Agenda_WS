package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiDaoUpdate;
import br.com.mind5.business.material.model.action.MatVisiEnforceLChanged;
import br.com.mind5.business.material.model.action.MatVisiMergeUsername;
import br.com.mind5.business.material.model.action.MatVisiNodeMatextUpsert;
import br.com.mind5.business.material.model.action.MatVisiNodeSnapshot;
import br.com.mind5.business.material.model.action.MatVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatNodeUpdate extends DeciTreeTemplateWrite<MatInfo> {
	
	public MatNodeUpdate(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
	
		ActionStd<MatInfo> enforceLChanged = new ActionStdCommom<MatInfo>(option, MatVisiEnforceLChanged.class);	
		ActionLazy<MatInfo> enforceLChangedBy = new ActionLazyCommom<MatInfo>(option, MatVisiMergeUsername.class);
		ActionLazy<MatInfo> updateMat = new ActionLazyCommom<MatInfo>(option, MatVisiDaoUpdate.class);		
		ActionLazy<MatInfo> upsertMatext = new ActionLazyCommom<MatInfo>(option, MatVisiNodeMatextUpsert.class);
		ActionLazy<MatInfo> snapshot = new ActionLazyCommom<MatInfo>(option, MatVisiNodeSnapshot.class);
		ActionLazy<MatInfo> select = new ActionLazyCommom<MatInfo>(option, MatVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateMat);
		updateMat.addPostAction(upsertMatext);
		upsertMatext.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
