package br.com.gda.payment.permissionResponseMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionResponseMoip.model.action.LazyPeresmoipEnforceExpected;
import br.com.gda.payment.permissionResponseMoip.model.action.LazyPeresmoipInsert;
import br.com.gda.payment.permissionResponseMoip.model.action.StdPeresmoipEnforceLChanged;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckExist;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckLangu;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckOwner;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckStore;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckWrite;

public final class RootPeresmoipInsert extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public RootPeresmoipInsert(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean DONT_EXIST = false;
		
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
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new PeresmoipCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> enforceLChanged = new StdPeresmoipEnforceLChanged(option);	
		ActionLazy<PeresmoipInfo> enforceExpected = new LazyPeresmoipEnforceExpected(option.conn, option.schemaName);
		ActionLazy<PeresmoipInfo> insert = new LazyPeresmoipInsert(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceExpected);
		enforceExpected.addPostAction(insert);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
