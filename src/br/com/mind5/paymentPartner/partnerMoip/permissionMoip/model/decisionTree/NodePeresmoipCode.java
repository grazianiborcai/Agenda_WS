package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipDelete;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipGenerateTokemoip;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipInsertStopar;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipEnforceExpected;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckIsExpected;

public final class NodePeresmoipCode extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public NodePeresmoipCode(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PeresmoipCheckIsExpected(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> enforceExpected = new StdPeresmoipEnforceExpected(option);
		ActionLazy<PeresmoipInfo> enforcePaypar = new LazyPeresmoipEnforcePaypar(option.conn, option.schemaName);
		ActionLazy<PeresmoipInfo> generateTokemoip = new LazyPeresmoipGenerateTokemoip(option.conn, option.schemaName);	
		ActionLazy<PeresmoipInfo> insertStopar = new LazyPeresmoipInsertStopar(option.conn, option.schemaName);	
		ActionLazy<PeresmoipInfo> delete = new LazyPeresmoipDelete(option.conn, option.schemaName);	
		
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(generateTokemoip);
		generateTokemoip.addPostAction(insertStopar);
		insertStopar.addPostAction(delete);
		
		actions.add(enforceExpected);		
		return actions;
	}
}
