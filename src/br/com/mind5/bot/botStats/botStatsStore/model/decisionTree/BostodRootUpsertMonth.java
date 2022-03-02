package br.com.mind5.bot.botStats.botStatsStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiSteddUpsertMonth;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiStedmonUpsert;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiStordUpsertMonth;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiStoronUpsert;
import br.com.mind5.bot.botStats.botStatsStore.model.checker.BostodCheckLangu;
import br.com.mind5.bot.botStats.botStatsStore.model.checker.BostodCheckOwner;
import br.com.mind5.bot.botStats.botStatsStore.model.checker.BostodCheckStore;
import br.com.mind5.bot.botStats.botStatsStore.model.checker.BostodCheckWriteMonth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class BostodRootUpsertMonth extends DeciTreeTemplateWrite<BostodInfo> {
	
	public BostodRootUpsertMonth(DeciTreeOption<BostodInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BostodInfo> buildCheckerHook(DeciTreeOption<BostodInfo> option) {
		List<ModelChecker<BostodInfo>> queue = new ArrayList<>();		
		ModelChecker<BostodInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new BostodCheckWriteMonth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostodCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostodCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostodCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BostodInfo>> buildActionsOnPassedHook(DeciTreeOption<BostodInfo> option) {
		List<ActionStd<BostodInfo>> actions = new ArrayList<>();

		ActionStd<BostodInfo> steddUpsert = new ActionStdCommom<BostodInfo>(option, BostodVisiSteddUpsertMonth.class);
		ActionLazy<BostodInfo> stedmonUpsert = new ActionLazyCommom<BostodInfo>(option.conn, option.schemaName, BostodVisiStedmonUpsert.class);
		ActionLazy<BostodInfo> stordUpsert = new ActionLazyCommom<BostodInfo>(option.conn, option.schemaName, BostodVisiStordUpsertMonth.class);
		ActionLazy<BostodInfo> storonUpsert = new ActionLazyCommom<BostodInfo>(option.conn, option.schemaName, BostodVisiStoronUpsert.class);
		
		steddUpsert.addPostAction(stedmonUpsert);
		stedmonUpsert.addPostAction(stordUpsert);
		stordUpsert.addPostAction(storonUpsert);
		
		actions.add(steddUpsert);
		return actions;
	}
}
