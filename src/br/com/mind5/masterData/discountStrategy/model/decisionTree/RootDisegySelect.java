package br.com.mind5.masterData.discountStrategy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.masterData.discountStrategy.model.action.StdDisegyDaoSelect;
import br.com.mind5.masterData.discountStrategy.model.checker.DisegyCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootDisegySelect extends DeciTreeTemplateRead<DisegyInfo> {
	
	public RootDisegySelect(DeciTreeOption<DisegyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisegyInfo> buildCheckerHook(DeciTreeOption<DisegyInfo> option) {
		List<ModelChecker<DisegyInfo>> queue = new ArrayList<>();		
		ModelChecker<DisegyInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new DisegyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<DisegyInfo>> buildActionsOnPassedHook(DeciTreeOption<DisegyInfo> option) {
		List<ActionStd<DisegyInfo>> actions = new ArrayList<>();
		
		ActionStd<DisegyInfo> select = new StdDisegyDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
