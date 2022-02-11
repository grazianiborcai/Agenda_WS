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
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowaliveEnforceHasData;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowaliveEnforceLChanged;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowaliveMergeMonth;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.LazySowaliveMergeState;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.StdSowaliveMergeToSelect;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowaliveCheckLangu;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowaliveCheckOwner;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowaliveCheckRead;


public final class RootSowaliveSelect extends DeciTreeTemplateWrite<SowaliveInfo> {
	
	public RootSowaliveSelect(DeciTreeOption<SowaliveInfo> option) {
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
		checker = new SowaliveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowaliveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowaliveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowaliveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowaliveInfo> option) {
		List<ActionStd<SowaliveInfo>> actions = new ArrayList<>();

		ActionStd<SowaliveInfo> select = new StdSowaliveMergeToSelect(option);
		ActionLazy<SowaliveInfo> enforceLChanged = new LazySowaliveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SowaliveInfo> enforceHasData = new LazySowaliveEnforceHasData(option.conn, option.schemaName);
		ActionLazy<SowaliveInfo> mergeState = new LazySowaliveMergeState(option.conn, option.schemaName);
		ActionLazy<SowaliveInfo> mergeMonth = new LazySowaliveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceHasData);
		enforceHasData.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
