package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiNodeSytotauh;
import br.com.mind5.business.material.model.action.MatVisiDaoDelete;
import br.com.mind5.business.material.model.action.MatVisiDaoUpdate;
import br.com.mind5.business.material.model.action.MatVisiEnforceLChanged;
import br.com.mind5.business.material.model.action.MatVisiMatextDelete;
import br.com.mind5.business.material.model.action.MatVisiMergeToDelete;
import br.com.mind5.business.material.model.action.MatVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatNodeDeleteL2 extends DeciTreeTemplateWrite<MatInfo> {
	
	public MatNodeDeleteL2(DeciTreeOption<MatInfo> option) {
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
		
		ActionStd<MatInfo> deleteMatext = new ActionStdCommom<MatInfo>(option, MatVisiMatextDelete.class);
		ActionStd<MatInfo> mergeToDelete = new ActionStdCommom<MatInfo>(option, MatVisiMergeToDelete.class);
		ActionLazy<MatInfo> nodeSytotauh = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeSytotauh.class);
		ActionLazy<MatInfo> enforceLChanged = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiEnforceLChanged.class);
		ActionLazy<MatInfo> enforceLChangedBy = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeUsername.class);
		ActionLazy<MatInfo> updateAttr = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiDaoUpdate.class);
		ActionLazy<MatInfo> delete = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiDaoDelete.class);
		
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
