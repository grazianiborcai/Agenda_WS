package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordDaoUpdate;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeToUpdate;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckUpdate;

public final class RootPayordUpdate extends DeciTreeTemplateWriteV2<PayordInfo> {
	
	public RootPayordUpdate(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelCheckerV1<PayordInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV1<PayordInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayordInfo> select = new StdPayordMergeToUpdate(option);
		ActionLazyV1<PayordInfo> updatePayord = new LazyPayordDaoUpdate(option.conn, option.schemaName);
		
		select.addPostAction(updatePayord);
		
		actions.add(select);
		return actions;
	}
}
