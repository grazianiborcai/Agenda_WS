package br.com.mind5.masterData.orderStatusSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.masterData.orderStatusSearch.model.action.StdOrderatarchDaoSelect;
import br.com.mind5.masterData.orderStatusSearch.model.checker.OrderatarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOrderatarchSelect extends DeciTreeTemplateRead<OrderatarchInfo> {
	
	public RootOrderatarchSelect(DeciTreeOption<OrderatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderatarchInfo> buildCheckerHook(DeciTreeOption<OrderatarchInfo> option) {
		List<ModelChecker<OrderatarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<OrderatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderatarchInfo> option) {
		List<ActionStd<OrderatarchInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderatarchInfo> select = new StdOrderatarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
