package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiDaoDelete;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiEnforceExpected;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiStoparInsert;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiTokemoipGenerate;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckIsExpected;

public final class PeresmoipNodeCode extends DeciTreeTemplateWrite<PeresmoipInfo> {
	
	public PeresmoipNodeCode(DeciTreeOption<PeresmoipInfo> option) {
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

		ActionStd<PeresmoipInfo> enforceExpected = new ActionStdCommom<PeresmoipInfo>(option, PeresmoipVisiEnforceExpected.class);
		ActionLazy<PeresmoipInfo> enforcePaypar = new ActionLazyCommom<PeresmoipInfo>(option, PeresmoipVisiEnforcePaypar.class);
		ActionLazy<PeresmoipInfo> generateTokemoip = new ActionLazyCommom<PeresmoipInfo>(option, PeresmoipVisiTokemoipGenerate.class);	
		ActionLazy<PeresmoipInfo> insertStopar = new ActionLazyCommom<PeresmoipInfo>(option, PeresmoipVisiStoparInsert.class);	
		ActionLazy<PeresmoipInfo> delete = new ActionLazyCommom<PeresmoipInfo>(option, PeresmoipVisiDaoDelete.class);	
		
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(generateTokemoip);
		generateTokemoip.addPostAction(insertStopar);
		insertStopar.addPostAction(delete);
		
		actions.add(enforceExpected);		
		return actions;
	}
}
