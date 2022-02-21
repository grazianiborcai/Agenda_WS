package br.com.mind5.bot.botStats.botStatsStoreSchedule.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action.LazyBostodMergeCalonthL2m;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action.LazyBostodRootUpsertMonth;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action.StdBostodMergeStolis;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.checker.BostodCheckLangu;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.checker.BostodCheckOwner;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.checker.BostodCheckWriteL2m;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootBostodUpsertL2m extends DeciTreeTemplateRead<BostodInfo> {
	
	public RootBostodUpsertL2m(DeciTreeOption<BostodInfo> option) {
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
		checker = new BostodCheckWriteL2m(checkerOption);
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BostodInfo>> buildActionsOnPassedHook(DeciTreeOption<BostodInfo> option) {
		List<ActionStd<BostodInfo>> actions = new ArrayList<>();

		ActionStd<BostodInfo> mergeStolis = new StdBostodMergeStolis(option);
		ActionLazy<BostodInfo> mergeCalonth = new LazyBostodMergeCalonthL2m(option.conn, option.schemaName);
		ActionLazy<BostodInfo> upsert = new LazyBostodRootUpsertMonth(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeCalonth);
		mergeCalonth.addPostAction(upsert);
		
		actions.add(mergeStolis);
		return actions;
	}
}
