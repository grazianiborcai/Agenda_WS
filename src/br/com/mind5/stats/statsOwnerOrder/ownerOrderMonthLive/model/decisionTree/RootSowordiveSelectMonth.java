package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action.LazySowordiveEnforceLChanged;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action.LazySowordiveMergeMonth;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action.LazySowordiveMergeState;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action.StdSowordiveMergeToSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.checker.SowordiveCheckLangu;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.checker.SowordiveCheckOwner;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.checker.SowordiveCheckRead;


public final class RootSowordiveSelectMonth extends DeciTreeTemplateWrite<SowordiveInfo> {
	
	public RootSowordiveSelectMonth(DeciTreeOption<SowordiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordiveInfo> buildCheckerHook(DeciTreeOption<SowordiveInfo> option) {
		List<ModelChecker<SowordiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowordiveInfo> checker;
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
	
	
	
	@Override protected List<ActionStd<SowordiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordiveInfo> option) {
		List<ActionStd<SowordiveInfo>> actions = new ArrayList<>();

		ActionStd<SowordiveInfo> select = new StdSowordiveMergeToSelect(option);
		ActionLazy<SowordiveInfo> enforceLChanged = new LazySowordiveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SowordiveInfo> mergeState = new LazySowordiveMergeState(option.conn, option.schemaName);
		ActionLazy<SowordiveInfo> mergeMonth = new LazySowordiveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
