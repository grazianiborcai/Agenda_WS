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
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazyUseraciveEnforceHasData;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazyUseraciveEnforceLChanged;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazyUseraciveMergeMonth;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.LazyUseraciveMergeState;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.StdUseraciveMergeToSelect;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker.UseraciveCheckLangu;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker.UseraciveCheckOwner;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker.UseraciveCheckRead;


public final class RootUseraciveSelect extends DeciTreeTemplateWrite<UseraciveInfo> {
	
	public RootUseraciveSelect(DeciTreeOption<UseraciveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UseraciveInfo> buildCheckerHook(DeciTreeOption<UseraciveInfo> option) {
		List<ModelChecker<UseraciveInfo>> queue = new ArrayList<>();		
		ModelChecker<UseraciveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new UseraciveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new UseraciveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new UseraciveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UseraciveInfo>> buildActionsOnPassedHook(DeciTreeOption<UseraciveInfo> option) {
		List<ActionStd<UseraciveInfo>> actions = new ArrayList<>();

		ActionStd<UseraciveInfo> select = new StdUseraciveMergeToSelect(option);
		ActionLazy<UseraciveInfo> enforceLChanged = new LazyUseraciveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<UseraciveInfo> enforceHasData = new LazyUseraciveEnforceHasData(option.conn, option.schemaName);
		ActionLazy<UseraciveInfo> mergeState = new LazyUseraciveMergeState(option.conn, option.schemaName);
		ActionLazy<UseraciveInfo> mergeMonth = new LazyUseraciveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceHasData);
		enforceHasData.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
