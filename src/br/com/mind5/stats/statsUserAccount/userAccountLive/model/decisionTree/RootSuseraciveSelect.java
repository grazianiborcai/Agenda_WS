package br.com.mind5.stats.statsUserAccount.userAccountLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazySuseraciveEnforceHasData;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazySuseraciveEnforceLChanged;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazySuseraciveMergeMonth;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazySuseraciveMergeState;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.StdSuseraciveMergeToSelect;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker.SuseraciveCheckLangu;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker.SuseraciveCheckOwner;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker.SuseraciveCheckRead;


public final class RootSuseraciveSelect extends DeciTreeTemplateWrite<SuseraciveInfo> {
	
	public RootSuseraciveSelect(DeciTreeOption<SuseraciveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SuseraciveInfo> buildCheckerHook(DeciTreeOption<SuseraciveInfo> option) {
		List<ModelChecker<SuseraciveInfo>> queue = new ArrayList<>();		
		ModelChecker<SuseraciveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SuseraciveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SuseraciveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SuseraciveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SuseraciveInfo>> buildActionsOnPassedHook(DeciTreeOption<SuseraciveInfo> option) {
		List<ActionStd<SuseraciveInfo>> actions = new ArrayList<>();

		ActionStd<SuseraciveInfo> select = new StdSuseraciveMergeToSelect(option);
		ActionLazy<SuseraciveInfo> enforceLChanged = new LazySuseraciveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SuseraciveInfo> enforceHasData = new LazySuseraciveEnforceHasData(option.conn, option.schemaName);
		ActionLazy<SuseraciveInfo> mergeState = new LazySuseraciveMergeState(option.conn, option.schemaName);
		ActionLazy<SuseraciveInfo> mergeMonth = new LazySuseraciveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceHasData);
		enforceHasData.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
