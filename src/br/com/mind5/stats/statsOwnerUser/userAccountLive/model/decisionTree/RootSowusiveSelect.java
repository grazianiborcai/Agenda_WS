package br.com.mind5.stats.statsOwnerUser.userAccountLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action.LazySowusiveEnforceHasData;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action.LazySowusiveEnforceLChanged;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action.LazySowusiveMergeMonth;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action.LazySowusiveMergeState;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action.StdSowusiveMergeToSelect;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.checker.SowusiveCheckLangu;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.checker.SowusiveCheckOwner;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.checker.SowusiveCheckRead;


public final class RootSowusiveSelect extends DeciTreeTemplateWrite<SowusiveInfo> {
	
	public RootSowusiveSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusiveInfo> buildCheckerHook(DeciTreeOption<SowusiveInfo> option) {
		List<ModelChecker<SowusiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowusiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowusiveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowusiveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowusiveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusiveInfo> option) {
		List<ActionStd<SowusiveInfo>> actions = new ArrayList<>();

		ActionStd<SowusiveInfo> select = new StdSowusiveMergeToSelect(option);
		ActionLazy<SowusiveInfo> enforceLChanged = new LazySowusiveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SowusiveInfo> enforceHasData = new LazySowusiveEnforceHasData(option.conn, option.schemaName);
		ActionLazy<SowusiveInfo> mergeState = new LazySowusiveMergeState(option.conn, option.schemaName);
		ActionLazy<SowusiveInfo> mergeMonth = new LazySowusiveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceHasData);
		enforceHasData.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
