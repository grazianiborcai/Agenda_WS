package br.com.mind5.stats.userOrderYearStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.userOrderYearStgn.model.action.LazyStusorygeDaoUpdate;
import br.com.mind5.stats.userOrderYearStgn.model.action.StdStusorygeEnforceLChanged;
import br.com.mind5.stats.userOrderYearStgn.model.checker.StusorygeCheckExist;
import br.com.mind5.stats.userOrderYearStgn.model.checker.StusorygeCheckRead;


public final class RootStusorygeUpdate extends DeciTreeTemplateWrite<StusorygeInfo> {
	
	public RootStusorygeUpdate(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygeInfo> buildCheckerHook(DeciTreeOption<StusorygeInfo> option) {
		List<ModelChecker<StusorygeInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorygeCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusorygeCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygeInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygeInfo> option) {
		List<ActionStd<StusorygeInfo>> actions = new ArrayList<>();

		ActionStd<StusorygeInfo> enforceLChanged = new StdStusorygeEnforceLChanged(option);
		ActionLazy<StusorygeInfo> update = new LazyStusorygeDaoUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(update);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
