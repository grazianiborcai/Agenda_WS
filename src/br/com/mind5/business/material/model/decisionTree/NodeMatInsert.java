package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatDaoInsert;
import br.com.mind5.business.material.model.action.LazyMatEnforceCreatedBy;
import br.com.mind5.business.material.model.action.LazyMatEnforceCreatedOn;
import br.com.mind5.business.material.model.action.LazyMatEnforceLChanged;
import br.com.mind5.business.material.model.action.LazyMatMergeUsername;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatInsert extends DeciTreeTemplateWriteV2<MatInfo> {
	
	public NodeMatInsert(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV1<MatInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatInfo> nodeService = new NodeMatServiceL1(option).toAction();	
		ActionLazyV1<MatInfo> enforceLChanged = new LazyMatEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> enforceCreatedOn = new LazyMatEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazyV1<MatInfo> enforceCreatedBy = new LazyMatEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> insertMat = new LazyMatDaoInsert(option.conn, option.schemaName);	
		
		nodeService.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insertMat);
		
		actions.add(nodeService);		
		return actions;
	}
}
