package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
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
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
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
	
	
	
	@Override protected List<ActionStdV1<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStdV1<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<PeresmoipInfo> enforceExpected = new StdPeresmoipEnforceExpected(option);
		ActionLazyV1<PeresmoipInfo> enforcePaypar = new LazyPeresmoipEnforcePaypar(option.conn, option.schemaName);
		ActionLazyV1<PeresmoipInfo> generateTokemoip = new LazyPeresmoipGenerateTokemoip(option.conn, option.schemaName);	
		ActionLazyV1<PeresmoipInfo> insertStopar = new LazyPeresmoipInsertStopar(option.conn, option.schemaName);	
		ActionLazyV1<PeresmoipInfo> delete = new LazyPeresmoipDelete(option.conn, option.schemaName);	
		
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(generateTokemoip);
		generateTokemoip.addPostAction(insertStopar);
		insertStopar.addPostAction(delete);
		
		actions.add(enforceExpected);		
		return actions;
	}
}
