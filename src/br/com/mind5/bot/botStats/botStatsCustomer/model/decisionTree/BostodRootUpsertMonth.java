package br.com.mind5.bot.botStats.botStatsCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostodVisiSteddUpsertMonth;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostodVisiStedmonUpsert;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostusVisiStefilonUpsert;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostodVisiStordUpsertMonth;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostodVisiStoronUpsert;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostodCheckLangu;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostodCheckOwner;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostodCheckStore;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostodCheckWriteMonth;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class BostodRootUpsertMonth extends DeciTreeTemplateWrite<BostusInfo> {
	
	public BostodRootUpsertMonth(DeciTreeOption<BostusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BostusInfo> buildCheckerHook(DeciTreeOption<BostusInfo> option) {
		List<ModelChecker<BostusInfo>> queue = new ArrayList<>();		
		ModelChecker<BostusInfo> checker;
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
	
	
	
	@Override protected List<ActionStd<BostusInfo>> buildActionsOnPassedHook(DeciTreeOption<BostusInfo> option) {
		List<ActionStd<BostusInfo>> actions = new ArrayList<>();

		ActionStd<BostusInfo> steddUpsert = new ActionStdCommom<BostusInfo>(option, BostodVisiSteddUpsertMonth.class);
		ActionStd<BostusInfo> stedmonUpsert = new ActionStdCommom<BostusInfo>(option, BostodVisiStedmonUpsert.class);
		ActionStd<BostusInfo> stordUpsert = new ActionStdCommom<BostusInfo>(option, BostodVisiStordUpsertMonth.class);
		ActionStd<BostusInfo> storonUpsert = new ActionStdCommom<BostusInfo>(option, BostodVisiStoronUpsert.class);
		ActionStd<BostusInfo> stefilonUpsert = new ActionStdCommom<BostusInfo>(option, BostusVisiStefilonUpsert.class);
		
		actions.add(steddUpsert);
		actions.add(stedmonUpsert);
		actions.add(stordUpsert);
		actions.add(storonUpsert);
		actions.add(stefilonUpsert);
		
		return actions;
	}
}
