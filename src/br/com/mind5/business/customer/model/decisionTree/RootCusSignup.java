package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusRootInsert;
import br.com.mind5.business.customer.model.action.StdCusMergeDaemon;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckSignup;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCusSignup extends DeciTreeTemplateWriteV2<CusInfo> {

	public RootCusSignup(DeciTreeOption<CusInfo> option) {
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
		checker = new CusCheckSignup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();
		//TODO: mesmo CPF mas email diferente :: da erro
		
		ActionStdV1<CusInfo> mergeDaemon = new StdCusMergeDaemon(option);
		ActionLazyV1<CusInfo> insert = new LazyCusRootInsert(option.conn, option.schemaName);
		
		mergeDaemon.addPostAction(insert);
		
		actions.add(mergeDaemon);	
		return actions;
	}
}
