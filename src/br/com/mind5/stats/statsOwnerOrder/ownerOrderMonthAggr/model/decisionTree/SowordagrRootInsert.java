package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action.SowordagrVisiDaoInsert;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action.SowordagrVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckExist;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckLangu;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckOwner;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckWrite;


public final class SowordagrRootInsert extends DeciTreeTemplateWrite<SowordagrInfo> {
	
	public SowordagrRootInsert(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordagrInfo> buildCheckerHook(DeciTreeOption<SowordagrInfo> option) {
		List<ModelChecker<SowordagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowordagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowordagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;
		checker = new SowordagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordagrInfo> option) {
		List<ActionStd<SowordagrInfo>> actions = new ArrayList<>();

		ActionStd<SowordagrInfo> enforceLChanged = new ActionStdCommom<SowordagrInfo>(option, SowordagrVisiEnforceLChanged.class);
		ActionLazy<SowordagrInfo> insert = new ActionLazyCommom<SowordagrInfo>(option.conn, option.schemaName, SowordagrVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
