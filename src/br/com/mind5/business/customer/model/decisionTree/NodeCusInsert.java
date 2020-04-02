package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusEnforceCreatedBy;
import br.com.mind5.business.customer.model.action.LazyCusEnforceCreatedOn;
import br.com.mind5.business.customer.model.action.LazyCusEnforceLChanged;
import br.com.mind5.business.customer.model.action.LazyCusInsert;
import br.com.mind5.business.customer.model.action.LazyCusMergeUsername;
import br.com.mind5.business.customer.model.action.StdCusEnforceReference;
import br.com.mind5.business.customer.model.checker.CusCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusInsert extends DeciTreeWriteTemplate<CusInfo> {

	public NodeCusInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;	
		
		checker = new CusCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();

		ActionStdV1<CusInfo> enforceReference = new StdCusEnforceReference(option);
		ActionLazyV1<CusInfo> enforceLChanged = new LazyCusEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> mergeLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);	
		ActionLazyV1<CusInfo> enforceCreatedBy = new LazyCusEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> enforceCreatedOn = new LazyCusEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> insertCustomer = new LazyCusInsert(option.conn, option.schemaName);
		
		enforceReference.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeLChangedBy);
		mergeLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertCustomer);
		
		actions.add(enforceReference);	
		return actions;
	}
}
