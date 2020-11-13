package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceLChanged;
import br.com.mind5.payment.payOrder.model.action.LazyPayordOrderRefresh;
import br.com.mind5.payment.payOrder.model.action.LazyPayordDaoUpdate;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeToUpdate;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckRefresh;

public final class RootPayordRefresh extends DeciTreeTemplateWriteV2<PayordInfo> {
	
	public RootPayordRefresh(DeciTreeOption<PayordInfo> option) {
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
		checker = new PayordCheckRefresh(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV2<PayordInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PayordInfo> select = new StdPayordMergeToUpdate(option);
		ActionLazy<PayordInfo> enforceLChanged = new LazyPayordEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PayordInfo> updatePayord = new LazyPayordDaoUpdate(option.conn, option.schemaName);
		ActionLazy<PayordInfo> refreshOrder = new LazyPayordOrderRefresh(option.conn, option.schemaName);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(updatePayord);
		updatePayord.addPostAction(refreshOrder);
		
		actions.add(select);
		return actions;
	}
}
