package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatDaoDelete;
import br.com.mind5.business.material.model.action.LazyMatDaoUpdate;
import br.com.mind5.business.material.model.action.LazyMatEnforceLChanged;
import br.com.mind5.business.material.model.action.LazyMatMergeUsername;
import br.com.mind5.business.material.model.action.LazyMatNodeSytotauh;
import br.com.mind5.business.material.model.action.StdMatMatextDelete;
import br.com.mind5.business.material.model.action.StdMatMergeToDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatDeleteL2 extends DeciTreeTemplateWrite<MatInfo> {
	
	public NodeMatDeleteL2(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> deleteMatext = new StdMatMatextDelete(option);
		ActionStd<MatInfo> mergeToDelete = new StdMatMergeToDelete(option);
		ActionLazy<MatInfo> nodeSytotauh = new LazyMatNodeSytotauh(option.conn, option.schemaName);
		ActionLazy<MatInfo> enforceLChanged = new LazyMatEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatInfo> updateAttr = new LazyMatDaoUpdate(option.conn, option.schemaName);
		ActionLazy<MatInfo> delete = new LazyMatDaoDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateAttr);
		updateAttr.addPostAction(delete);
		
		actions.add(deleteMatext);
		actions.add(mergeToDelete);
		return actions;
	}
}
