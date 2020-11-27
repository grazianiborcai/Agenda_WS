package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.LazyCusarchMergeToSelect;
import br.com.mind5.business.customerSearch.model.action.LazyCusarchNodeSelectL2;
import br.com.mind5.business.customerSearch.model.action.StdCusarchEnforceStore;
import br.com.mind5.business.customerSearch.model.action.StdCusarchMergeSytotauh;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckSytotin;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeCusarchSelectL1 extends DeciTreeTemplateRead<CusarchInfo> {
	
	public NodeCusarchSelectL1(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusarchInfo> buildCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelChecker<CusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusarchCheckSytotin(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> mergeSytotauh = new StdCusarchMergeSytotauh(option);
		ActionLazy<CusarchInfo> nodeL2 = new LazyCusarchNodeSelectL2(option.conn, option.schemaName);
		
		mergeSytotauh.addPostAction(nodeL2);
		
		actions.add(mergeSytotauh);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnFailedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> obfuscateStore = new StdCusarchEnforceStore(option);
		ActionLazy<CusarchInfo> select = new LazyCusarchMergeToSelect(option.conn, option.schemaName);
		
		obfuscateStore.addPostAction(select);
		
		actions.add(obfuscateStore);
		return actions;
	}
}
