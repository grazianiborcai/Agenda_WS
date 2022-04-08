package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.MatoreVisiNodeSnapshot;
import br.com.mind5.business.materialStore.model.action.MatoreVisiRootSelect;
import br.com.mind5.business.materialStore.model.action.MatoreVisiDaoInsert;
import br.com.mind5.business.materialStore.model.action.MatoreVisiDaoUpdate;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceCreatedBy;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceCreatedOn;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceLChanged;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeUsername;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoreNodeUpsertL8 extends DeciTreeTemplateWrite<MatoreInfo> {
	
	public MatoreNodeUpsertL8(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new MatoreCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> enforceLChanged = new ActionStdCommom<MatoreInfo>(option, MatoreVisiEnforceLChanged.class);
		ActionLazy<MatoreInfo> enforceLChangedBy = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeUsername.class);
		ActionLazy<MatoreInfo> enforceCreatedOn = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceCreatedOn.class);	
		ActionLazy<MatoreInfo> enforceCreatedBy = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceCreatedBy.class);
		ActionLazy<MatoreInfo> insert = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiDaoInsert.class);
		ActionLazy<MatoreInfo> snapshot = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiNodeSnapshot.class);
		ActionLazy<MatoreInfo> select = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnFailedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> enforceLChanged = new ActionStdCommom<MatoreInfo>(option, MatoreVisiEnforceLChanged.class);
		ActionLazy<MatoreInfo> enforceLChangedBy = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeUsername.class);
		ActionLazy<MatoreInfo> enforceCreatedOn = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceCreatedOn.class);	
		ActionLazy<MatoreInfo> enforceCreatedBy = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceCreatedBy.class);
		ActionLazy<MatoreInfo> update = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiDaoUpdate.class);
		ActionLazy<MatoreInfo> snapshot = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiNodeSnapshot.class);
		ActionLazy<MatoreInfo> select = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
