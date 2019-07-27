package br.com.gda.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.action.LazyPayordemEnforceLChanged;
import br.com.gda.payment.payOrderItem.model.action.LazyPayordemUpdate;
import br.com.gda.payment.payOrderItem.model.action.StdPayordemMergeToUpdate;
import br.com.gda.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.gda.payment.payOrderItem.model.checker.PayordemCheckUpdate;

public final class RootPayordemUpdate extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public RootPayordemUpdate(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PayordemCheckUpdate();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordemCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> select = new StdPayordemMergeToUpdate(option);
		ActionLazy<PayordemInfo> enforceLChanged = new LazyPayordemEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> update = new LazyPayordemUpdate(option.conn, option.schemaName);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		
		actions.add(select);
		return actions;
	}
}
