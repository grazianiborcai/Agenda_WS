package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovDaoInsert;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovEnforceCreatedBy;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovEnforceCreatedOn;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovEnforcePostingDate;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovMergeUsername;
import br.com.mind5.business.materialMovement.model.action.StdMatmovEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatmovInsert extends DeciTreeTemplateWrite<MatmovInfo> {
	
	public NodeMatmovInsert(DeciTreeOption<MatmovInfo> option) {
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

		ActionStd<MatmovInfo> enforceLChanged = new StdMatmovEnforceLChanged(option);
		ActionLazy<MatmovInfo> enforceLChangedBy = new LazyMatmovMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> enforceCreatedOn = new LazyMatmovEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<MatmovInfo> enforceCreatedBy = new LazyMatmovEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> enforcePostingDate = new LazyMatmovEnforcePostingDate(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> insert = new LazyMatmovDaoInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforcePostingDate);
		enforcePostingDate.addPostAction(insert);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
