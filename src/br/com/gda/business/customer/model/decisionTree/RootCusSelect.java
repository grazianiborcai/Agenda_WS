package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusMergeAddress;
import br.com.gda.business.customer.model.action.LazyCusMergePerson;
import br.com.gda.business.customer.model.action.LazyCusMergePhone;
import br.com.gda.business.customer.model.action.LazyCusMergeUser;
import br.com.gda.business.customer.model.action.StdCusSelect;
import br.com.gda.business.customer.model.checker.CusCheckLangu;
import br.com.gda.business.customer.model.checker.CusCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootCusSelect extends DeciTreeReadTemplate<CusInfo> {
	
	public RootCusSelect(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new CusCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> select = new StdCusSelect(option);
		ActionLazy<CusInfo> mergePerson = new LazyCusMergePerson(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergeAddress = new LazyCusMergeAddress(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergePhone = new LazyCusMergePhone(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergeUser = new LazyCusMergeUser(option.conn, option.schemaName);
		//ActionLazy<CusInfo> mergePersonUser = new LazyCusMergePersonUser(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		
		actions.add(select);
		return actions;
	}
}
