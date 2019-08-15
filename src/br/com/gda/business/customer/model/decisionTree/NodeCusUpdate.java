package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusEnforceEntityCateg;
import br.com.gda.business.customer.model.action.LazyCusEnforceLChanged;
import br.com.gda.business.customer.model.action.LazyCusMergeUsername;
import br.com.gda.business.customer.model.action.LazyCusUpdate;
import br.com.gda.business.customer.model.action.StdCusMergeToUpdate;
import br.com.gda.business.customer.model.checker.CusCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusUpdate extends DeciTreeWriteTemplate<CusInfo> {
	
	public NodeCusUpdate(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;		
		
		checker = new CusCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		//TODO: verificar se person não mudou
		ActionStd<CusInfo> mergeToUpdate = new StdCusMergeToUpdate(option);
		ActionLazy<CusInfo> enforceLChanged = new LazyCusEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceEntityCateg = new LazyCusEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<CusInfo> updateCustomer = new LazyCusUpdate(option.conn, option.schemaName);		
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceEntityCateg);			
		enforceEntityCateg.addPostAction(updateCustomer);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
