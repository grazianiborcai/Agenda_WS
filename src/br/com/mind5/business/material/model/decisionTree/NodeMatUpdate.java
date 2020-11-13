package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatDaoUpdate;
import br.com.mind5.business.material.model.action.LazyMatEnforceLChanged;
import br.com.mind5.business.material.model.action.LazyMatMergeUsername;
import br.com.mind5.business.material.model.action.LazyMatNodeServiceL1;
import br.com.mind5.business.material.model.action.LazyMatNodeSytotauh;
import br.com.mind5.business.material.model.action.StdMatMergeToUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatUpdate extends DeciTreeTemplateWrite<MatInfo> {
	
	public NodeMatUpdate(DeciTreeOption<MatInfo> option) {
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

		ActionStd<MatInfo> mergeToUpdate = new StdMatMergeToUpdate(option);
		ActionLazy<MatInfo> nodeSytotauh = new LazyMatNodeSytotauh(option.conn, option.schemaName);
		ActionLazy<MatInfo> nodeService = new LazyMatNodeServiceL1(option.conn, option.schemaName);	
		ActionLazy<MatInfo> enforceLChanged = new LazyMatEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatInfo> updateMat = new LazyMatDaoUpdate(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(nodeService);
		nodeService.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateMat);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
