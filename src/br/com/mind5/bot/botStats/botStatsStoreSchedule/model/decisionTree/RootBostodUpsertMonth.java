package br.com.mind5.bot.botStats.botStatsStoreSchedule.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action.LazyBostodStedmonUpsert;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action.StdBostodSteddUpsertMonth;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.checker.BostodCheckLangu;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.checker.BostodCheckOwner;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.checker.BostodCheckStore;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.checker.BostodCheckWriteMonth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class RootBostodUpsertMonth extends DeciTreeTemplateWrite<BostodInfo> {
	
	public RootBostodUpsertMonth(DeciTreeOption<BostodInfo> option) {
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

		ActionStd<BostodInfo> steddUpsert = new StdBostodSteddUpsertMonth(option);
		ActionLazy<BostodInfo> stedmonUpsert = new LazyBostodStedmonUpsert(option.conn, option.schemaName);
		
		steddUpsert.addPostAction(stedmonUpsert);
		
		actions.add(steddUpsert);
		return actions;
	}
}
