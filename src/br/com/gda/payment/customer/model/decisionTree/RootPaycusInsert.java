package br.com.gda.payment.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.model.action.LazyPaycusEnforceLChanged;
import br.com.gda.payment.customer.model.action.StdPaycusMergeUsername;
import br.com.gda.payment.customer.model.checker.PaycusCheckLangu;
import br.com.gda.payment.customer.model.checker.PaycusCheckOwner;
import br.com.gda.payment.customer.model.action.LazyPaycusInsert;
import br.com.gda.payment.customer.model.action.LazyPaycusMergeUser;
import br.com.gda.payment.customer.model.checker.PaycusCheckInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPaycusInsert extends DeciTreeWriteTemplate<PaycusInfo> {
	
	public RootPaycusInsert(DeciTreeOption<PaycusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaycusInfo> buildDecisionCheckerHook(DeciTreeOption<PaycusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PaycusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaycusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PaycusCheckInsert();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaycusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaycusCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaycusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaycusInfo> option) {
		List<ActionStd<PaycusInfo>> actions = new ArrayList<>();
		
		ActionStd<PaycusInfo> mergeUsername = new StdPaycusMergeUsername(option);
		ActionLazy<PaycusInfo> mergeUser = new LazyPaycusMergeUser(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> enforceLChanged = new LazyPaycusEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<PaycusInfo> insert = new LazyPaycusInsert(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(mergeUser);
		mergeUser.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		
		actions.add(mergeUsername);
		return actions;
	}
}
