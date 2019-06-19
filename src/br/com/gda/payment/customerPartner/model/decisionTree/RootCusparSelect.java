package br.com.gda.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergeToSelect;
import br.com.gda.payment.customerPartner.model.action.StdCusparMergeUsername;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootCusparSelect extends DeciTreeReadTemplate<CusparInfo> {
	
	public RootCusparSelect(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CusparCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		
		
		ActionStd<CusparInfo> mergeUser = new StdCusparMergeUsername(option);
		ActionLazy<CusparInfo> select = new LazyCusparMergeToSelect(option.conn, option.schemaName);
		
		mergeUser.addPostAction(select);
		
		actions.add(mergeUser);			
		return actions;
	}
}
