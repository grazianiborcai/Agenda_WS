package br.com.gda.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.action.LazyPayordEnforceLChanged;
import br.com.gda.payment.payOrder.model.action.LazyPayordOrderUpdate;
import br.com.gda.payment.payOrder.model.action.LazyPayordUpdate;
import br.com.gda.payment.payOrder.model.action.StdPayordMergeToUpdate;
import br.com.gda.payment.payOrder.model.checker.PayordCheckExist;
import br.com.gda.payment.payOrder.model.checker.PayordCheckUpdate;

public final class RootPayordUpdate extends DeciTreeWriteTemplate<PayordInfo> {
	
	public RootPayordUpdate(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PayordCheckUpdate();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordInfo> select = new StdPayordMergeToUpdate(option);
		ActionLazy<PayordInfo> enforceLChanged = new LazyPayordEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PayordInfo> updatePayord = new LazyPayordUpdate(option.conn, option.schemaName);
		ActionLazy<PayordInfo> updateOrder = new LazyPayordOrderUpdate(option.conn, option.schemaName);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(updatePayord);
		updatePayord.addPostAction(updateOrder);
		
		actions.add(select);
		return actions;
	}
}
