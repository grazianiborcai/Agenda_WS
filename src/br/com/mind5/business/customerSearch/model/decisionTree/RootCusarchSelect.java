package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.LazyCusarchMergeToSelect;
import br.com.mind5.business.customerSearch.model.action.StdCusarchEnforceEntityCateg;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckOwner;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCusarchSelect extends DeciTreeReadTemplate<CusarchInfo> {
	
	public RootCusarchSelect(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusarchInfo> buildDecisionCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelChecker<CusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.SUCCESS;	
		checker = new CusarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> enforceEntityCateg = new StdCusarchEnforceEntityCateg(option);
		ActionLazy<CusarchInfo> select = new LazyCusarchMergeToSelect(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(select);
		
		actions.add(enforceEntityCateg);
		return actions;
	}
}
