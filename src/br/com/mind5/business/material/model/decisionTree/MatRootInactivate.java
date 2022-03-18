package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiEnforceLockedOn;
import br.com.mind5.business.material.model.action.MatVisiMergeToSelect;
import br.com.mind5.business.material.model.action.MatVisiNodeSytotauh;
import br.com.mind5.business.material.model.action.MatVisiNodeUpdate;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.material.model.checker.MatCheckLangu;
import br.com.mind5.business.material.model.checker.MatCheckOwner;
import br.com.mind5.business.material.model.checker.MatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatRootInactivate extends DeciTreeTemplateWrite<MatInfo> {
	
	public MatRootInactivate(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckLangu(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();

		ActionStd<MatInfo> mergeToSelect = new ActionStdCommom<MatInfo>(option, MatVisiMergeToSelect.class);
		ActionLazy<MatInfo> nodeSytotauh = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeSytotauh.class);
		ActionLazy<MatInfo> enforceLockedOn = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiEnforceLockedOn.class);
		ActionLazy<MatInfo> nodeUpdate = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeUpdate.class);	
		
		mergeToSelect.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLockedOn);
		enforceLockedOn.addPostAction(nodeUpdate);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
