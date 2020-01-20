package br.com.mind5.business.orderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.action.StdOrdarchMergeToSelect;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckLangu;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckOwner;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdarchSelect extends DeciTreeReadTemplate<OrdarchInfo> {
	
	public RootOrdarchSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdarchInfo> buildDecisionCheckerHook(DeciTreeOption<OrdarchInfo> option) {
		List<ModelChecker<OrdarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdarchCheckOwner(checkerOption);
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
