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
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiNodeInsertL1;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiEnforceExpected;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiEnforceLChanged;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.PeresmoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckLangu;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckOwner;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckStore;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckUsername;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckWrite;

public final class PeresmoipRootInsert extends DeciTreeTemplateWrite<PeresmoipInfo> {
	
	public PeresmoipRootInsert(DeciTreeOption<PeresmoipInfo> option) {
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
		checker = new PeresmoipCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> enforceLChanged = new ActionStdCommom<PeresmoipInfo>(option, PeresmoipVisiEnforceLChanged.class);	
		ActionLazy<PeresmoipInfo> enforceExpected = new ActionLazyCommom<PeresmoipInfo>(option, PeresmoipVisiEnforceExpected.class);
		ActionLazy<PeresmoipInfo> enforcePaypar = new ActionLazyCommom<PeresmoipInfo>(option, PeresmoipVisiEnforcePaypar.class);
		ActionLazy<PeresmoipInfo> nodeInsertL1 = new ActionLazyCommom<PeresmoipInfo>(option, PeresmoipVisiNodeInsertL1.class);	
		
		enforceLChanged.addPostAction(enforceExpected);
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(nodeInsertL1);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
