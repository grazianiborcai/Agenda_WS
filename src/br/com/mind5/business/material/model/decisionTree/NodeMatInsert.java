package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatDaoInsert;
import br.com.mind5.business.material.model.action.LazyMatEnforceCreatedBy;
import br.com.mind5.business.material.model.action.LazyMatEnforceCreatedOn;
import br.com.mind5.business.material.model.action.LazyMatEnforceLChanged;
import br.com.mind5.business.material.model.action.LazyMatMergeSytotauh;
import br.com.mind5.business.material.model.action.LazyMatMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatInsert extends DeciTreeTemplateWrite<MatInfo> {
	
	public NodeMatInsert(DeciTreeOption<MatInfo> option) {
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
		
		ActionStd<MatInfo> nodeService = new NodeMatServiceL1(option).toAction();	
		ActionLazy<MatInfo> enforceLChanged = new LazyMatEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatInfo> enforceCreatedOn = new LazyMatEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<MatInfo> enforceCreatedBy = new LazyMatEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeSytotauh = new LazyMatMergeSytotauh(option.conn, option.schemaName);
		ActionLazy<MatInfo> insertMat = new LazyMatDaoInsert(option.conn, option.schemaName);	
		
		nodeService.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(mergeSytotauh);
		mergeSytotauh.addPostAction(insertMat);
		
		actions.add(nodeService);		
		return actions;
	}
}
