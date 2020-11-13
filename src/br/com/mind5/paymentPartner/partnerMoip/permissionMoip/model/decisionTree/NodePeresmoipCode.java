package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipDaoDelete;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipTokemoipGenerate;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipStoparInsert;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipEnforceExpected;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckIsExpected;

public final class NodePeresmoipCode extends DeciTreeTemplateWrite<PeresmoipInfo> {
	
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> enforceExpected = new StdPeresmoipEnforceExpected(option);
		ActionLazy<PeresmoipInfo> enforcePaypar = new LazyPeresmoipEnforcePaypar(option.conn, option.schemaName);
		ActionLazy<PeresmoipInfo> generateTokemoip = new LazyPeresmoipTokemoipGenerate(option.conn, option.schemaName);	
		ActionLazy<PeresmoipInfo> insertStopar = new LazyPeresmoipStoparInsert(option.conn, option.schemaName);	
		ActionLazy<PeresmoipInfo> delete = new LazyPeresmoipDaoDelete(option.conn, option.schemaName);	
		
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(generateTokemoip);
		generateTokemoip.addPostAction(insertStopar);
		insertStopar.addPostAction(delete);
		
		actions.add(enforceExpected);		
		return actions;
	}
}
