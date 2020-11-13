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
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatmovInsert extends DeciTreeTemplateWriteV2<MatmovInfo> {
	
	public NodeMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelCheckerV1<MatmovInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatmovInfo> checker;		

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStdV2<MatmovInfo>> actions = new ArrayList<>();

		ActionStdV2<MatmovInfo> enforceLChanged = new StdMatmovEnforceLChanged(option);
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
