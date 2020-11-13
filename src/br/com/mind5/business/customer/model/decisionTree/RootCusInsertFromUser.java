package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusEnforceUserData;
import br.com.mind5.business.customer.model.action.LazyCusRootInsertSilent;
import br.com.mind5.business.customer.model.action.LazyCusRootSelect;
import br.com.mind5.business.customer.model.action.StdCusMergeUser;
import br.com.mind5.business.customer.model.checker.CusCheckInsertFromUser;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCusInsertFromUser extends DeciTreeTemplateWriteV2<CusInfo> {

	public RootCusInsertFromUser(DeciTreeOption<CusInfo> option) {
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
		checker = new CusCheckInsertFromUser(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<CusInfo> mergeUser = new StdCusMergeUser(option);
		ActionLazy<CusInfo> copyUserData = new LazyCusEnforceUserData(option.conn, option.schemaName);		
		ActionLazy<CusInfo> insert = new LazyCusRootInsertSilent(option.conn, option.schemaName);
		ActionLazy<CusInfo> select = new LazyCusRootSelect(option.conn, option.schemaName);	
		
		mergeUser.addPostAction(copyUserData);
		copyUserData.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(mergeUser);	
		return actions;
	}
}
