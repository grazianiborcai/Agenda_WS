package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovEnforceCreatedBy;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovEnforceCreatedOn;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovEnforcePostingDate;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovInsert;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovMergeUsername;
import br.com.mind5.business.materialMovement.model.action.StdMatmovEnforceLChanged;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class NodeMatmovInsert extends DeciTreeTemplateWriteV1<MatmovInfo> {
	
	public NodeMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelCheckerV1<MatmovInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatmovInfo> checker;		

		checker = new MatmovCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStdV1<MatmovInfo>> actions = new ArrayList<>();

		ActionStdV1<MatmovInfo> enforceLChanged = new StdMatmovEnforceLChanged(option);
		ActionLazyV1<MatmovInfo> enforceLChangedBy = new LazyMatmovMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatmovInfo> enforceCreatedOn = new LazyMatmovEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazyV1<MatmovInfo> enforceCreatedBy = new LazyMatmovEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<MatmovInfo> enforcePostingDate = new LazyMatmovEnforcePostingDate(option.conn, option.schemaName);
		ActionLazyV1<MatmovInfo> insert = new LazyMatmovInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforcePostingDate);
		enforcePostingDate.addPostAction(insert);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
