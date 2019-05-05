package br.com.gda.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.model.action.LazyCusarchMergeLangu;
import br.com.gda.business.customerSearch.model.action.LazyCusarchMergeToSelect;
import br.com.gda.business.customerSearch.model.action.StdCusarchEnforceEntityCateg;
import br.com.gda.business.customerSearch.model.checker.CusarchCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootCusarchSelect extends DeciTreeReadTemplate<CusarchInfo> {
	
	public RootCusarchSelect(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusarchInfo> buildDecisionCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelChecker<CusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusarchInfo> checker;
		
		checker = new CusarchCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> enforceEntityCateg = new StdCusarchEnforceEntityCateg(option);
		ActionLazy<CusarchInfo> select = new LazyCusarchMergeToSelect(option.conn, option.schemaName);
		ActionLazy<CusarchInfo> mergeLangu = new LazyCusarchMergeLangu(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(select);
		select.addPostAction(mergeLangu);
		
		actions.add(enforceEntityCateg);
		return actions;
	}
}
