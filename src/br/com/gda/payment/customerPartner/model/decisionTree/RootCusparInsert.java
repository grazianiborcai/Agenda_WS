package br.com.gda.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparEnforceLChanged;
import br.com.gda.payment.customerPartner.model.action.LazyCusparInsert;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergeUser;
import br.com.gda.payment.customerPartner.model.action.StdCusparMergeUsername;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckInsert;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckOwner;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusparInsert extends DeciTreeWriteTemplate<CusparInfo> {
	
	public RootCusparInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CusparCheckInsert();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd<CusparInfo> mergeUsername = new StdCusparMergeUsername(option);
		ActionLazy<CusparInfo> mergeUser = new LazyCusparMergeUser(option.conn, option.schemaName);
		ActionLazy<CusparInfo> enforceLChanged = new LazyCusparEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<CusparInfo> insert = new LazyCusparInsert(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(mergeUser);
		mergeUser.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		
		actions.add(mergeUsername);
		return actions;
	}
}
