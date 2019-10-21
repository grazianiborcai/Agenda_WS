package br.com.mind5.payment.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.action.LazyPeresmoipEnforceExpected;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.action.LazyPeresmoipEnforcePaypar;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.action.LazyPeresmoipNodeInsertL1;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.action.StdPeresmoipEnforceLChanged;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckLangu;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckOwner;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckStore;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckUsername;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckWrite;

public final class RootPeresmoipInsert extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public RootPeresmoipInsert(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PeresmoipCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PeresmoipCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PeresmoipCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PeresmoipCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PeresmoipCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> enforceLChanged = new StdPeresmoipEnforceLChanged(option);	
		ActionLazy<PeresmoipInfo> enforceExpected = new LazyPeresmoipEnforceExpected(option.conn, option.schemaName);
		ActionLazy<PeresmoipInfo> enforcePaypar = new LazyPeresmoipEnforcePaypar(option.conn, option.schemaName);
		ActionLazy<PeresmoipInfo> nodeInsertL1 = new LazyPeresmoipNodeInsertL1(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceExpected);
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(nodeInsertL1);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
