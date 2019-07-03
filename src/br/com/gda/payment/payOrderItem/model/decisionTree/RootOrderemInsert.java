package br.com.gda.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemMergeMat;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemNodeInsert;
import br.com.gda.payment.payOrderItem.model.action.StdOrderemEnforceCreatedOn;
import br.com.gda.payment.payOrderItem.model.checker.OrderemCheckLangu;
import br.com.gda.payment.payOrderItem.model.checker.OrderemCheckMat;
import br.com.gda.payment.payOrderItem.model.checker.OrderemCheckOrder;
import br.com.gda.payment.payOrderItem.model.checker.OrderemCheckOwner;
import br.com.gda.payment.payOrderItem.model.checker.OrderemCheckWrite;

public final class RootOrderemInsert extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public RootOrderemInsert(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderemCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckOrder(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> enforceCreatedOn = new StdOrderemEnforceCreatedOn(option);
		ActionLazy<PayordemInfo> mergeMat = new LazyOrderemMergeMat(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> nodeInsert = new LazyOrderemNodeInsert(option.conn, option.schemaName);
		
		enforceCreatedOn.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeInsert);
		
		actions.add(enforceCreatedOn);
		return actions;
	}
}
