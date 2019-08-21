package br.com.gda.business.orderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderSearch.info.OrdarchInfo;
import br.com.gda.business.orderSearch.model.action.StdOrdarchMergeToSelect;
import br.com.gda.business.orderSearch.model.checker.OrdarchCheckLangu;
import br.com.gda.business.orderSearch.model.checker.OrdarchCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdarchSelect extends DeciTreeReadTemplate<OrdarchInfo> {
	
	public RootOrdarchSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdarchInfo> buildDecisionCheckerHook(DeciTreeOption<OrdarchInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdarchCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdarchInfo> option) {
		List<ActionStd<OrdarchInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdarchInfo> select = new StdOrdarchMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}
