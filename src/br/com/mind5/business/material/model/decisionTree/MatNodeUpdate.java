package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiDaoUpdate;
import br.com.mind5.business.material.model.action.MatVisiEnforceLChanged;
import br.com.mind5.business.material.model.action.MatVisiMergeUsername;
import br.com.mind5.business.material.model.action.MatVisiNodeMatextUpsert;
import br.com.mind5.business.material.model.action.MatVisiNodeServiceL1;
import br.com.mind5.business.material.model.action.MatVisiNodeSnapshot;
import br.com.mind5.business.material.model.action.MatVisiNodeSytotauh;
import br.com.mind5.business.material.model.action.MatVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatNodeUpdate extends DeciTreeTemplateWrite<MatInfo> {
	
	public MatNodeUpdate(DeciTreeOption<MatInfo> option) {
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

		ActionStd<MatInfo> nodeSytotauh = new ActionStdCommom<MatInfo>(option, MatVisiNodeSytotauh.class);
		ActionLazy<MatInfo> nodeService = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeServiceL1.class);	
		ActionLazy<MatInfo> enforceLChanged = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiEnforceLChanged.class);	
		ActionLazy<MatInfo> enforceLChangedBy = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeUsername.class);
		ActionLazy<MatInfo> updateMat = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiDaoUpdate.class);		
		ActionLazy<MatInfo> upsertMatext = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeMatextUpsert.class);
		ActionLazy<MatInfo> snapshot = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeSnapshot.class);
		ActionLazy<MatInfo> select = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiRootSelect.class);
		
		nodeSytotauh.addPostAction(nodeService);
		nodeService.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateMat);
		updateMat.addPostAction(upsertMatext);
		upsertMatext.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(nodeSytotauh);
		return actions;
	}
}
