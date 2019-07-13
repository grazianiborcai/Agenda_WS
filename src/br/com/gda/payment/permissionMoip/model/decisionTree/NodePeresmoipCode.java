package br.com.gda.payment.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionMoip.model.action.LazyPeresmoipDelete;
import br.com.gda.payment.permissionMoip.model.action.LazyPeresmoipEnforceExpected;
import br.com.gda.payment.permissionMoip.model.action.LazyPeresmoipEnforcePaypar;
import br.com.gda.payment.permissionMoip.model.action.LazyPeresmoipGenerateTokemoip;
import br.com.gda.payment.permissionMoip.model.action.LazyPeresmoipInsertStopar;
import br.com.gda.payment.permissionMoip.model.action.StdPeresmoipMergeToSelect;
import br.com.gda.payment.permissionMoip.model.checker.PeresmoipCheckIsExpected;

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
		ActionLazy<PeresmoipInfo> enforcePaypar = new LazyPeresmoipEnforcePaypar(option.conn, option.schemaName);
		ActionLazy<PeresmoipInfo> insertStopar = new LazyPeresmoipInsertStopar(option.conn, option.schemaName);	
		ActionLazy<PeresmoipInfo> generateTokemoip = new LazyPeresmoipGenerateTokemoip(option.conn, option.schemaName);	
		ActionLazy<PeresmoipInfo> delete = new LazyPeresmoipDelete(option.conn, option.schemaName);	
		
		mergeToSelect.addPostAction(enforceExpected);
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(insertStopar);
		insertStopar.addPostAction(generateTokemoip);
		generateTokemoip.addPostAction(delete);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
