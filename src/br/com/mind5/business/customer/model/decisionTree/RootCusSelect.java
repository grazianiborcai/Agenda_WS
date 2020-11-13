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
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCusSelect extends DeciTreeTemplateReadV2<CusInfo> {
	
	public RootCusSelect(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelCheckerV1<CusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusInfo> select = new StdCusMergeToSelect(option);
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
