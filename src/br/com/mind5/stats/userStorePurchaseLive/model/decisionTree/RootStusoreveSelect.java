package br.com.mind5.stats.userStorePurchaseLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.userStorePurchaseLive.info.StusoreveInfo;
import br.com.mind5.stats.userStorePurchaseLive.model.action.StdStusoreveMergeToSelect;
import br.com.mind5.stats.userStorePurchaseLive.model.checker.StusoreveCheckRead;


public final class RootStusoreveSelect extends DeciTreeTemplateWrite<StusoreveInfo> {
	
	public RootStusoreveSelect(DeciTreeOption<StusoreveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoreveInfo> buildCheckerHook(DeciTreeOption<StusoreveInfo> option) {
		List<ModelChecker<StusoreveInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoreveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusoreveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoreveInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoreveInfo> option) {
		List<ActionStd<StusoreveInfo>> actions = new ArrayList<>();

		ActionStd<StusoreveInfo> select = new StdStusoreveMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
