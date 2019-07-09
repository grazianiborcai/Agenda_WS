package br.com.gda.payment.permissionResponseMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionResponseMoip.model.action.LazyPeresmoipEnforceExpected;
import br.com.gda.payment.permissionResponseMoip.model.action.LazyPeresmoipInsert;
import br.com.gda.payment.permissionResponseMoip.model.action.StdPeresmoipMergeToSelect;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckIsExpected;

public final class NodePeresmoipCode extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public NodePeresmoipCode(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;	
		
		checker = new PeresmoipCheckIsExpected();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> mergeToSelect = new StdPeresmoipMergeToSelect(option);	
		ActionLazy<PeresmoipInfo> enforceExpected = new LazyPeresmoipEnforceExpected(option.conn, option.schemaName);
		ActionLazy<PeresmoipInfo> insert = new LazyPeresmoipInsert(option.conn, option.schemaName);	
		
		mergeToSelect.addPostAction(enforceExpected);
		enforceExpected.addPostAction(insert);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
