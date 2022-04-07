package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.MatmovVisiDaoInsert;
import br.com.mind5.business.materialMovement.model.action.MatmovVisiEnforceCreatedBy;
import br.com.mind5.business.materialMovement.model.action.MatmovVisiEnforceCreatedOn;
import br.com.mind5.business.materialMovement.model.action.MatmovVisiEnforceLChanged;
import br.com.mind5.business.materialMovement.model.action.MatmovVisiEnforcePostingDate;
import br.com.mind5.business.materialMovement.model.action.MatmovVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatmovNodeInsert extends DeciTreeTemplateWrite<MatmovInfo> {
	
	public MatmovNodeInsert(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;		

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> enforceLChanged = new ActionStdCommom<MatmovInfo>(option, MatmovVisiEnforceLChanged.class);
		ActionLazy<MatmovInfo> enforceLChangedBy = new ActionLazyCommom<MatmovInfo>(option, MatmovVisiMergeUsername.class);
		ActionLazy<MatmovInfo> enforceCreatedOn = new ActionLazyCommom<MatmovInfo>(option, MatmovVisiEnforceCreatedOn.class);	
		ActionLazy<MatmovInfo> enforceCreatedBy = new ActionLazyCommom<MatmovInfo>(option, MatmovVisiEnforceCreatedBy.class);
		ActionLazy<MatmovInfo> enforcePostingDate = new ActionLazyCommom<MatmovInfo>(option, MatmovVisiEnforcePostingDate.class);
		ActionLazy<MatmovInfo> insert = new ActionLazyCommom<MatmovInfo>(option, MatmovVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforcePostingDate);
		enforcePostingDate.addPostAction(insert);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
