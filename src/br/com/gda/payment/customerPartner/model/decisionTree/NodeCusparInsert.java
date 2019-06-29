package br.com.gda.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparEnforceCompoundId;
import br.com.gda.payment.customerPartner.model.action.LazyCusparNodeCreateMoip;
import br.com.gda.payment.customerPartner.model.action.StdCusparInsert;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckPhonapUser;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckAddresnapUser;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckExistByUser;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusparInsert extends DeciTreeWriteTemplate<CusparInfo> {
	
	public NodeCusparInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;	
		checker = new CusparCheckExistByUser(checkerOption);
		queue.add(checker);
		
		checker = new CusparCheckAddresnapUser();
		queue.add(checker);
		
		checker = new CusparCheckPhonapUser();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd<CusparInfo> insert = new StdCusparInsert(option);
		ActionLazy<CusparInfo> enforceCompoundId = new LazyCusparEnforceCompoundId(option.conn, option.schemaName);	
		ActionLazy<CusparInfo> createMoip = new LazyCusparNodeCreateMoip(option.conn, option.schemaName);
		
		insert.addPostAction(enforceCompoundId);
		enforceCompoundId.addPostAction(createMoip);
		
		actions.add(insert);
		return actions;
	}
}
