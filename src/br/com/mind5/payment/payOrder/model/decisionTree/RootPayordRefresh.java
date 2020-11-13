package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceLChanged;
import br.com.mind5.payment.payOrder.model.action.LazyPayordOrderRefresh;
import br.com.mind5.payment.payOrder.model.action.LazyPayordDaoUpdate;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeToUpdate;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckRefresh;

public final class RootPayordRefresh extends DeciTreeTemplateWrite<PayordInfo> {
	
	public RootPayordRefresh(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordInfo> select = new StdPayordMergeToUpdate(option);
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
