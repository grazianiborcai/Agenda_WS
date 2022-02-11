package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowordiveEnforceHasData;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowordiveEnforceLChanged;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowordiveMergeMonth;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowordiveMergeState;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.StdSowordiveMergeToSelect;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowordiveCheckLangu;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowordiveCheckOwner;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowordiveCheckRead;


public final class RootSowordiveSelect extends DeciTreeTemplateWrite<SowaliveInfo> {
	
	public RootSowordiveSelect(DeciTreeOption<SowaliveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowaliveInfo> buildCheckerHook(DeciTreeOption<SowaliveInfo> option) {
		List<ModelChecker<SowaliveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowaliveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowordiveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowordiveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowordiveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowaliveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowaliveInfo> option) {
		List<ActionStd<SowaliveInfo>> actions = new ArrayList<>();

		ActionStd<SowaliveInfo> select = new StdSowordiveMergeToSelect(option);
		ActionLazy<SowaliveInfo> enforceLChanged = new LazySowordiveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SowaliveInfo> enforceHasData = new LazySowordiveEnforceHasData(option.conn, option.schemaName);
		ActionLazy<SowaliveInfo> mergeState = new LazySowordiveMergeState(option.conn, option.schemaName);
		ActionLazy<SowaliveInfo> mergeMonth = new LazySowordiveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceHasData);
		enforceHasData.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
