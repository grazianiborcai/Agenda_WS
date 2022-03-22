package br.com.mind5.bot.botStats.botStatsCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostusVisiCustamonUpsert;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostusCheckCus;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostusCheckLangu;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostusCheckOwner;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostusCheckWriteMonth;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class BostusRootUpsertMonth extends DeciTreeTemplateWrite<BostusInfo> {
	
	public BostusRootUpsertMonth(DeciTreeOption<BostusInfo> option) {
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
		checker = new BostusCheckWriteMonth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostusCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostusCheckCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BostusInfo>> buildActionsOnPassedHook(DeciTreeOption<BostusInfo> option) {
		List<ActionStd<BostusInfo>> actions = new ArrayList<>();

		ActionStd<BostusInfo> custamonUpsert = new ActionStdCommom<BostusInfo>(option, BostusVisiCustamonUpsert.class);
		
		actions.add(custamonUpsert);
		
		return actions;
	}
}
