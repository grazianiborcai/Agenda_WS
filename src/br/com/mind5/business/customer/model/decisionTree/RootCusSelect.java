package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusMergeAddress;
import br.com.mind5.business.customer.model.action.LazyCusMergeFimist;
import br.com.mind5.business.customer.model.action.LazyCusMergePerson;
import br.com.mind5.business.customer.model.action.LazyCusMergePhone;
import br.com.mind5.business.customer.model.action.LazyCusNodeSytotauh;
import br.com.mind5.business.customer.model.action.LazyCusNodeUser;
import br.com.mind5.business.customer.model.action.StdCusMergeToSelect;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCusSelect extends DeciTreeTemplateRead<CusInfo> {
	
	public RootCusSelect(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new CusCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> select = new StdCusMergeToSelect(option);
		ActionLazy<CusInfo> nodeSytotauh = new LazyCusNodeSytotauh(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergePerson = new LazyCusMergePerson(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergeAddress = new LazyCusMergeAddress(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergePhone = new LazyCusMergePhone(option.conn, option.schemaName);
		ActionLazy<CusInfo> nodeUser = new LazyCusNodeUser(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergeFimist = new LazyCusMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(nodeUser);
		nodeUser.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
