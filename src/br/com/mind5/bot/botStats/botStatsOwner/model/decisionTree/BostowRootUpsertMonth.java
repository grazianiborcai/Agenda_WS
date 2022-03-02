package br.com.mind5.bot.botStats.botStatsOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiSowalUpsert;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiSowedulUpsert;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiSowordUpsert;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiSowotUpsert;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiSowusUpsert;
import br.com.mind5.bot.botStats.botStatsOwner.model.checker.BostowCheckLangu;
import br.com.mind5.bot.botStats.botStatsOwner.model.checker.BostowCheckOwner;
import br.com.mind5.bot.botStats.botStatsOwner.model.checker.BostowCheckWriteMonth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class BostowRootUpsertMonth extends DeciTreeTemplateWrite<BostowInfo> {
	
	public BostowRootUpsertMonth(DeciTreeOption<BostowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BostowInfo> buildCheckerHook(DeciTreeOption<BostowInfo> option) {
		List<ModelChecker<BostowInfo>> queue = new ArrayList<>();		
		ModelChecker<BostowInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new BostowCheckWriteMonth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostowCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostowCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BostowInfo>> buildActionsOnPassedHook(DeciTreeOption<BostowInfo> option) {
		List<ActionStd<BostowInfo>> actions = new ArrayList<>();

		ActionStd<BostowInfo> sowordUpsert = new ActionStdCommom<BostowInfo>(option, BostowVisiSowordUpsert.class);
		ActionLazy<BostowInfo> sowalUpsert = new ActionLazyCommom<BostowInfo>(option.conn, option.schemaName, BostowVisiSowalUpsert.class);
		ActionLazy<BostowInfo> sowedulUpsert = new ActionLazyCommom<BostowInfo>(option.conn, option.schemaName, BostowVisiSowedulUpsert.class);
		ActionLazy<BostowInfo> sowotUpsert = new ActionLazyCommom<BostowInfo>(option.conn, option.schemaName, BostowVisiSowotUpsert.class);
		ActionLazy<BostowInfo> sowusUpsert = new ActionLazyCommom<BostowInfo>(option.conn, option.schemaName, BostowVisiSowusUpsert.class);
		
		sowordUpsert.addPostAction(sowalUpsert);
		sowalUpsert.addPostAction(sowedulUpsert);
		sowedulUpsert.addPostAction(sowotUpsert);
		sowotUpsert.addPostAction(sowusUpsert);
		
		actions.add(sowordUpsert);
		return actions;
	}
}
