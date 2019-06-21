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
import br.com.gda.payment.payOrder.model.action.LazyPayordDelete;
import br.com.gda.payment.payOrder.model.action.LazyPayordEnforceLChanged;
import br.com.gda.payment.payOrder.model.action.LazyPayordMergeUsername;
import br.com.gda.payment.payOrder.model.action.LazyPayordUpdate;
import br.com.gda.payment.payOrder.model.action.StdPayordMergeToDelete;
import br.com.gda.payment.payOrder.model.checker.PayordCheckExist;
import br.com.gda.payment.payOrder.model.checker.PayordCheckLangu;
import br.com.gda.payment.payOrder.model.checker.PayordCheckStorauth;
import br.com.gda.payment.payOrder.model.checker.PayordCheckWrite;

public final class RootPayordDelete extends DeciTreeWriteTemplate<PayordInfo> {
	
	public RootPayordDelete(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();	
		checker = new PayordCheckWrite();
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayordCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayordCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayordCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<PayordInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();
		//TODO: nao pode elimnar se for Owner-Default
		ActionStd<PayordInfo> mergeToDelete = new StdPayordMergeToDelete(option);
		ActionLazy<PayordInfo> enforceLChanged = new LazyPayordEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PayordInfo> enforceLChangedBy = new LazyPayordMergeUsername(option.conn, option.schemaName);
		ActionLazy<PayordInfo> update = new LazyPayordUpdate(option.conn, option.schemaName);
		ActionLazy<PayordInfo> delete = new LazyPayordDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;		
	}
}
