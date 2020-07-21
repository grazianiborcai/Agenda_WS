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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatUpdate extends DeciTreeTemplateWriteV2<MatInfo> {
	
	public NodeMatUpdate(DeciTreeOption<MatInfo> option) {
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

		ActionStdV1<MatInfo> mergeToUpdate = new StdMatMergeToUpdate(option);
		ActionLazyV1<MatInfo> nodeSytotauh = new LazyMatNodeSytotauh(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> nodeService = new LazyMatNodeServiceL1(option.conn, option.schemaName);	
		ActionLazyV1<MatInfo> enforceLChanged = new LazyMatEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> updateMat = new LazyMatDaoUpdate(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(nodeService);
		nodeService.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateMat);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
