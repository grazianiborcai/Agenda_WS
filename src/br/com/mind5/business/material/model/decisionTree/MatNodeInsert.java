package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiDaoInsert;
import br.com.mind5.business.material.model.action.MatVisiEnforceCreatedBy;
import br.com.mind5.business.material.model.action.MatVisiEnforceCreatedOn;
import br.com.mind5.business.material.model.action.MatVisiEnforceLChanged;
import br.com.mind5.business.material.model.action.MatVisiEnforceLockedOff;
import br.com.mind5.business.material.model.action.MatVisiMergeSytotauh;
import br.com.mind5.business.material.model.action.MatVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatNodeInsert extends DeciTreeTemplateWrite<MatInfo> {
	
	public MatNodeInsert(DeciTreeOption<MatInfo> option) {
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
		
		ActionStd<MatInfo> nodeService = new MatNodeServiceL1(option).toAction();	
		ActionLazy<MatInfo> enforceLChanged = new ActionLazyCommom<MatInfo>(option, MatVisiEnforceLChanged.class);	
		ActionLazy<MatInfo> enforceLChangedBy = new ActionLazyCommom<MatInfo>(option, MatVisiMergeUsername.class);
		ActionLazy<MatInfo> enforceCreatedOn = new ActionLazyCommom<MatInfo>(option, MatVisiEnforceCreatedOn.class);	
		ActionLazy<MatInfo> enforceCreatedBy = new ActionLazyCommom<MatInfo>(option, MatVisiEnforceCreatedBy.class);
		ActionLazy<MatInfo> enforceLockedOff = new ActionLazyCommom<MatInfo>(option, MatVisiEnforceLockedOff.class);
		ActionLazy<MatInfo> mergeSytotauh = new ActionLazyCommom<MatInfo>(option, MatVisiMergeSytotauh.class);
		ActionLazy<MatInfo> insertMat = new ActionLazyCommom<MatInfo>(option, MatVisiDaoInsert.class);	
		
		nodeService.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceLockedOff);
		enforceLockedOff.addPostAction(mergeSytotauh);
		mergeSytotauh.addPostAction(insertMat);
		
		actions.add(nodeService);		
		return actions;
	}
}
