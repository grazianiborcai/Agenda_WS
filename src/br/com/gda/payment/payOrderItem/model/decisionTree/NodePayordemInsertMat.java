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
import br.com.gda.payment.payOrderItem.model.action.LazyPayordemInsert;
import br.com.gda.payment.payOrderItem.model.action.StdPayordemMergeStopar;
import br.com.gda.payment.payOrderItem.model.checker.PayordemCheckInsertMat;
import br.com.gda.payment.payOrderItem.model.checker.PayordemCheckStopar;

public final class NodePayordemInsertMat extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public NodePayordemInsertMat(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PayordemCheckInsertMat();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordemCheckStopar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> mergeStopar = new StdPayordemMergeStopar(option);
		ActionLazy<PayordemInfo> insert = new LazyPayordemInsert(option.conn, option.schemaName);
		
		mergeStopar.addPostAction(insert);
		
		actions.add(mergeStopar);
		return actions;
	}
}
