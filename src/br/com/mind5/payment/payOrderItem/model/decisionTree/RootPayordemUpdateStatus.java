package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemEnforceLChanged;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemUpdate;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemMergeToUpdateStatus;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckUpdate;

public final class RootPayordemUpdateStatus extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public RootPayordemUpdateStatus(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordemCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordemCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStdV1<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayordemInfo> select = new StdPayordemMergeToUpdateStatus(option);
		ActionLazyV1<PayordemInfo> enforceLChanged = new LazyPayordemEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<PayordemInfo> update = new LazyPayordemUpdate(option.conn, option.schemaName);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		
		actions.add(select);
		return actions;
	}
}
