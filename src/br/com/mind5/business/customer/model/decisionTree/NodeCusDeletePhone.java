package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusPhoneDelete;
import br.com.mind5.business.customer.model.action.StdCusMergePhone;
import br.com.mind5.business.customer.model.action.StdCusSuccess;
import br.com.mind5.business.customer.model.checker.CusCheckPhonarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCusDeletePhone extends DeciTreeTemplateWrite<CusInfo> {
	
	public NodeCusDeletePhone(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckPhonarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> mergePhone = new StdCusMergePhone(option);
		ActionLazy<CusInfo> deletePhone = new LazyCusPhoneDelete(option.conn, option.schemaName);
		
		mergePhone.addPostAction(deletePhone);
		
		actions.add(mergePhone);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnFailedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCusSuccess(option));		
		return actions;
	}
}
