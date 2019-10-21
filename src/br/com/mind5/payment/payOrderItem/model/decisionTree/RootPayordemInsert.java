package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemNodeInsert;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemEnforceLChanged;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckInsert;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckLangu;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckOwner;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckPayord;

public final class RootPayordemInsert extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public RootPayordemInsert(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PayordemCheckInsert();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordemCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordemCheckPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> enforceLChanged = new StdPayordemEnforceLChanged(option);
		ActionLazy<PayordemInfo> nodeInsert = new LazyPayordemNodeInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(nodeInsert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
