package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.LazySowotiveEnforceHasData;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.LazySowotiveEnforceLChanged;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.LazySowotiveMergeMonth;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.LazySowotiveMergeState;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.StdSowotiveMergeToSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.checker.SowotiveCheckLangu;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.checker.SowotiveCheckOwner;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.checker.SowotiveCheckRead;


public final class RootSowotiveSelect extends DeciTreeTemplateWrite<SowotiveInfo> {
	
	public RootSowotiveSelect(DeciTreeOption<SowotiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotiveInfo> buildCheckerHook(DeciTreeOption<SowotiveInfo> option) {
		List<ModelChecker<SowotiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowotiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowotiveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowotiveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowotiveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotiveInfo> option) {
		List<ActionStd<SowotiveInfo>> actions = new ArrayList<>();

		ActionStd<SowotiveInfo> select = new StdSowotiveMergeToSelect(option);
		ActionLazy<SowotiveInfo> enforceLChanged = new LazySowotiveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SowotiveInfo> enforceHasData = new LazySowotiveEnforceHasData(option.conn, option.schemaName);
		ActionLazy<SowotiveInfo> mergeState = new LazySowotiveMergeState(option.conn, option.schemaName);
		ActionLazy<SowotiveInfo> mergeMonth = new LazySowotiveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceHasData);
		enforceHasData.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
