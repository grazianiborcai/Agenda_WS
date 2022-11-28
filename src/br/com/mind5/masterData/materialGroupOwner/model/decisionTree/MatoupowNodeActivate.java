package br.com.mind5.masterData.materialGroupOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceLockedOff;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeToSelect;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiNodeUpdate;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiRootSelect;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoupowNodeActivate extends DeciTreeTemplateWrite<MatoupowInfo> {
	
	public MatoupowNodeActivate(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupowInfo> buildCheckerHook(DeciTreeOption<MatoupowInfo> option) {
		List<ModelChecker<MatoupowInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupowInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoupowCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();

		ActionStd<MatoupowInfo> mergeToSelect = new ActionStdCommom<MatoupowInfo>(option, MatoupowVisiMergeToSelect.class);
		ActionLazy<MatoupowInfo> enforceLockedOff = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceLockedOff.class);
		ActionLazy<MatoupowInfo> nodeUpdate = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiNodeUpdate.class);
		ActionLazy<MatoupowInfo> select = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiRootSelect.class);
		
		mergeToSelect.addPostAction(enforceLockedOff);
		enforceLockedOff.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(select);
		
		actions.add(mergeToSelect);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnFailedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();

		ActionStd<MatoupowInfo> insert = new MatoupowRootInsertWhite(option).toAction();
		ActionLazy<MatoupowInfo> enforceLockedOff = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceLockedOff.class);
		ActionLazy<MatoupowInfo> nodeUpdate = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiNodeUpdate.class);
		ActionLazy<MatoupowInfo> select = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiRootSelect.class);
		
		insert.addPostAction(enforceLockedOff);
		enforceLockedOff.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(select);
		
		actions.add(insert);
		return actions;
	}
}
