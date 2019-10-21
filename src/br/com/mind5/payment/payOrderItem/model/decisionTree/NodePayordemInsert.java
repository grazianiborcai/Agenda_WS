package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckIsFee;

public final class NodePayordemInsert extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public NodePayordemInsert(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		final boolean IS_FEE = true;
		
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = IS_FEE;	
		checker = new PayordemCheckIsFee(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> nodeInsertFee = new NodePayordemInsertFee(option).toAction();
		
		actions.add(nodeInsertFee);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnFailedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> nodeInsertMat = new NodePayordemInsertMat(option).toAction();
		
		actions.add(nodeInsertMat);
		return actions;
	}
}
