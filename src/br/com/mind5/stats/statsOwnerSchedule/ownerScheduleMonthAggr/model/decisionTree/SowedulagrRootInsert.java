package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.SowedulagrVisiDaoInsert;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.SowedulagrVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckExist;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckLangu;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckOwner;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckWrite;


public final class SowedulagrRootInsert extends DeciTreeTemplateWrite<SowedulagrInfo> {
	
	public SowedulagrRootInsert(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulagrInfo> buildCheckerHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ModelChecker<SowedulagrInfo>> queue = new ArrayList<>();		
		ModelChecker<SowedulagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowedulagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SowedulagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SowedulagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new SowedulagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ActionStd<SowedulagrInfo>> actions = new ArrayList<>();

		ActionStd<SowedulagrInfo> enforceLChanged = new ActionStdCommom<SowedulagrInfo>(option, SowedulagrVisiEnforceLChanged.class);
		ActionLazy<SowedulagrInfo> insert = new ActionLazyCommom<SowedulagrInfo>(option.conn, option.schemaName, SowedulagrVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
